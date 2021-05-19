package com.select.web.import

import com.google.gson.Gson
import com.select.dao.impl.AccountDAOImpl
import com.select.service.impl.AccountServiceImpl
import com.select.utils.CsvDataImport
import org.apache.commons.fileupload.FileItem
import org.apache.commons.fileupload.disk.DiskFileItemFactory
import org.apache.commons.fileupload.servlet.ServletFileUpload
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import kotlin.Throws
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.File
import java.io.IOException
import java.io.PrintWriter
import javax.servlet.ServletException

@WebServlet(name = "ImportTeachersServlet", value = ["/ImportTeachersServlet"])
class ImportTeachersServlet : HttpServlet() {
    private val serialVersionUID = 1L

    // 上传文件存储目录
    private val UPLOAD_DIRECTORY = "upload"

    // 上传配置
    private val MEMORY_THRESHOLD = 1024 * 1024 * 3 // 3MB
    private val MAX_FILE_SIZE = 1024 * 1024 * 40 // 40MB
    private val MAX_REQUEST_SIZE = 1024 * 1024 * 50 // 50MB

    /**
     * 上传数据及保存文件
     */
    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            val writer: PrintWriter = response.getWriter()
            writer.println("Error: 表单必须包含 enctype=multipart/form-data")
            writer.flush()
            return
        }

        // 配置上传参数
        val factory = DiskFileItemFactory()
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD)
        // 设置临时存储目录
        factory.setRepository(File(System.getProperty("java.io.tmpdir")))
        val upload = ServletFileUpload(factory)

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE.toLong())

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE.toLong())

        // 中文处理
        upload.setHeaderEncoding("UTF-8")

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        val uploadPath: String =
            getServletContext().getRealPath("/").toString() + File.separator + UPLOAD_DIRECTORY


        // 如果目录不存在则创建
        val uploadDir = File(uploadPath)
        if (!uploadDir.exists()) {
            uploadDir.mkdir()
        }
        try {
            // 解析请求的内容提取文件数据
            val formItems: List<FileItem> = upload.parseRequest(request)
            if (formItems != null && formItems.size > 0) {
                // 迭代表单数据
                for (item in formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        val fileName: String = File(item.getName()).getName()
                        val filePath = uploadPath + File.separator + fileName
                        val storeFile = File(filePath)
                        // 在控制台输出文件的上传路径
                        println(filePath)
                        // 保存文件到硬盘
                        item.write(storeFile)


                        // 执行导入操作
                        val csvDataImport = CsvDataImport()
                        val accountService = AccountServiceImpl()
                        var teachers= csvDataImport.importAccounts(filePath)

                        for(teacher in teachers){
                            println(teacher.toString())
                            println("save: ${accountService.registerTeacher(teacher)}")
                        }
                        // 返回消息
                        request.setAttribute(
                            "message",
                            "文件上传成功!"
                        )
                    }
                }
            }
        } catch (ex: Exception) {
            request.setAttribute(
                "message",
                "错误信息: " + ex.message
            )
        }


        // 跳转到 message.jsp
        getServletContext().getRequestDispatcher("/message.jsp").forward(
            request, response
        )

    }


}
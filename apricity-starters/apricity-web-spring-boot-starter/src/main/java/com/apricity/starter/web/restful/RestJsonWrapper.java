package com.apricity.starter.web.restful;

/**
 * 请求JSON格式:
 * {<br>
 *     "param": {参数<br>
 *         "page"           : 当前页,
 *         "size"           : 每页数量,
 *         "conditions"     : 条件查询,
 *         "validators"     : 验证,
 *         "columns"        : 表格列配置,
 *         "order"          : 排序
 *         "download"       : 下载参数
 *              {
 *                  title       : 文件名称
 *                  columns     : 表格列
 *              }
 *          “更多自定义参数”
 *     },
 *     repository: "service bean名称"
 *     data: [] 数据列表
 * }
 */
public class RestJsonWrapper {

}

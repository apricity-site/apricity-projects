## param 参数示例

```json
{
  "page": 1,
  "size": 10,
  "where": {
    "column1": {
      "type": "string",
      "_eq": "value"
    },
    "column2": {
      "_like_left": "value"
    },
    "_or": {
      "column3": {
        "type": "number",
        "_eq": "value"
      },
      "column4": {
        "type": "number",
        "_range": "[1,10]"
      }
    },
    "column5": "_is_null",
    "column6": "_is_not_null",
    "column7": {
      "type": "date",
      "_range": "(2021-01-01,2021-10-01)"
    },
    "column8": {
      "type": "datetime",
      "_range": "(2021-01-01 00:00:00,2021-10-01 00:00:00]"
    }
  },
  "order_by": {
    "columnName": "asc"
  }
}
```

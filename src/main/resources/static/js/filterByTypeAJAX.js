function filterByType(filename) {
    var Handler = function (Request) {
        //how it comes
        //{"productList":[{"id":252,"name":"onion","price":10.0,"productType":{"id":1,"type":"candy"}},{"id":253,"name":"negi","price":300.0,"productType":{"id":4,"type":"\uD83D\uDC3A"}},{"id":254,"name":"honey","price":25.0,"productType":{"id":1,"type":"candy"}},{"id":255,"name":"cola","price":600.0,"productType":{"id":2,"type":"飲み物"}},{"id":256,"name":"urmum","price":30.0,"productType":{"id":3,"type":"ケーキ"}}],"productTypeList":[{"id":1,"type":"candy"},{"id":2,"type":"飲み物"},{"id":3,"type":"ケーキ"},{"id":4,"type":"\uD83D\uDC3A"}]}
        //BECAUSE JSON
        //var responsedata = eval("(" + Request.responseText + ")");
        //PARSING JSON STRING
        let responsedata = JSON.parse(Request.responseText);
        let productList = responsedata.productList;
        let productTypeList = responsedata.productTypeList;
        // INSERTING NEW DATA TO THE HTML
        outputProductList = "";
        for (var i = 0; i < productList.length; i++){
            outputProductList += '<div>' +
                '<img src="image/bear.jpg" width="200" height="200">' +
                '<span>' + productList[i].name + '</span>' +
                '<br>' + '<span>' + productList[i].price +'</span>' +
                '<br>' + '<span>' + productList[i].productType.type + '</span>' +
                '</div>'
        }
        document.getElementById("productList").innerHTML = outputProductList;
    }
    // FETCHING DATA FROM id="DACHECK" CHECKBOXES
    let checkedValue = [];
    var inputElements = document.getElementsByClassName("daCheck");
    for(var i = 0; inputElements[i];i++){
        if (inputElements[i].checked){
            checkedValue.push(inputElements[i].value);
        }
    }
    // Sending request
    let r_args = "id=" + checkedValue;
    SendRequest("POST", filename, r_args, Handler)
}
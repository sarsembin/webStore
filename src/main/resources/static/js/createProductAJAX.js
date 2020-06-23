function createProduct(filename)
{
    //Создаем функцию обработчик
    var Handler = function(Request)
    {
        //how it comes
        //{"productList":[{"id":252,"name":"onion","price":10.0,"productType":{"id":1,"type":"candy"}},{"id":253,"name":"negi","price":300.0,"productType":{"id":4,"type":"\uD83D\uDC3A"}},{"id":254,"name":"honey","price":25.0,"productType":{"id":1,"type":"candy"}},{"id":255,"name":"cola","price":600.0,"productType":{"id":2,"type":"飲み物"}},{"id":256,"name":"urmum","price":30.0,"productType":{"id":3,"type":"ケーキ"}}],"productTypeList":[{"id":1,"type":"candy"},{"id":2,"type":"飲み物"},{"id":3,"type":"ケーキ"},{"id":4,"type":"\uD83D\uDC3A"}]}
        //BECAUSE JSON
        //var responsedata = eval("(" + Request.responseText + ")");
        let responseData = JSON.parse(Request.responseText);
        let productList = responseData.productList;
        let productTypeList = responseData.productTypeList;

        outputProductList = "";
        for (var i = 0; i < productList.length; i++){
            outputProductList += '<div>' +
                '<img src="image/bear.jpg" width="200" height="200">' +
                '<span>' + productList[i].name + '</span>' +
                '<br>' + '<span>' + productList[i].price +'</span>' +
                '<br>' + '<span>' + productList[i].productType.type + '</span>' +
                '</div>'
        }
        outputProductTypeList = "";
        for(var i = 0; i < productTypeList.length; i++){
            outputProductTypeList += '<option value = ' + productTypeList[i].id + '>' + productTypeList[i].type + '</option>'
        }
        document.getElementById("productList").innerHTML = outputProductList;
        document.getElementById("productTypeSelect").innerHTML = outputProductTypeList;

        document.getElementById("inputName").value = "";
        document.getElementById("inputPrice").value = "";
    }
    //Отправляем запрос
    let inputName = document.getElementById("inputName").value;
    let inputPrice = document.getElementById("inputPrice").value;
    let inputType = document.getElementById("productTypeSelect").value;
    //window.alert(inputName + " " + inputPrice + " " + inputType + " Product added");
    let r_args = "name=" + inputName + '&' +
        "price=" + inputPrice + '&' +
        "type=" + inputType;
    SendRequest("POST",filename,r_args,Handler);
}

function doAjaxPost() {
    document.cookie = 'cookie1=test1; expires=Sun, 1 Jan 2023 00:00:00 UTC; path=/';
    var desc = $("#desc").val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/getData",
        data: {"param1":desc},
        success: function(response){
            if(response.status == "SUCCESS"){
                userInfo = response.result;

                var res = window.localStorage.getItem('res');
                if (res === ""){
                    window.localStorage.setItem('res', userInfo);
                } else {
                    var res = window.localStorage.getItem('res');
                    userInfo += res;
                    window.localStorage.setItem('res', userInfo);
                }

                window.location.href = "http://localhost:8080/";
             }else{
                 errorInfo = "";
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });

}
function personCompletion() {
    const submitInformation = {
        "username": usernameHeader,
        "firstName": $("#firstName").val(),
        "lastName": $("#lastName").val(),
        "fathersName": $("#fathersName").val(),
        "nationalCode": $("#nationalCode").val(),
        "degreeOfEducation": $("#degreeOfEducation").val(),
        "phoneNumber": $("#phoneNumber").val(),
        "cellPhoneNumber": $("#cellPhoneNumber").val(),
        "email": $("#email").val(),
        "address": $("#address").val()
    };

    $.ajax({
        url: serverUrl() + "/personCompletion",
        type: "POST",
        data: JSON.stringify(submitInformation), headers: {
            "Authorization": "Basic " + btoa(usernameHeader + ":" + passwordHeader)
        },
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            showAlert('success', 'اطلاعات شما با موفقیت ثبت گردید. لطفا منتظر تایید مدیر باشید باتشکر');
        },
        error: function (errorMessage) {
            showAlert('danger', errorMessage.responseJSON.message);
        }
    })
}

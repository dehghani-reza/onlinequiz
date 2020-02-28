function showAlert(type, message) {
    $("#response").animate({}, 300);
    $('<div class="alert alert-' + type + '">' +
        '<button type="button" class="close" data-dismiss="alert">' +
        '&times;</button>' + message + '</div>').hide().appendTo('#response').fadeIn(1000);
    $(".alert").delay(3000).fadeOut(
        "normal",
        function () {
            $(this).remove();
        })
}

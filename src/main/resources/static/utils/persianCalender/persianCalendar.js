$(function () {
    //usage
    $(".usage").persianDatepicker({ formatDate: "YYYY-0M-0D" });

    //themes
    $("#pdpDefault").persianDatepicker({ alwaysShow: true, });
    $("#pdpLatoja").persianDatepicker({ theme: "latoja", alwaysShow: true, });
    $("#pdpLightorang").persianDatepicker({ theme: "lightorang", alwaysShow: true, });
    $("#pdpMelon").persianDatepicker({ theme: "melon", alwaysShow: true, });
    $("#pdpDark").persianDatepicker({ theme: "dark", alwaysShow: true, });

    //size
    $("#pdpSmall").persianDatepicker({ cellWidth: 14, cellHeight: 12, fontSize: 8 });
    $("#pdpBig").persianDatepicker({ cellWidth: 78, cellHeight: 60, fontSize: 18 });

    //formatting
    $("#pdpF1").persianDatepicker({ formatDate: "YYYY/0M/0D 0h:0m:0s:ms" });
    $("#pdpF2").persianDatepicker({ formatDate: "YYYY-0M-0D" });
    $("#pdpF3").persianDatepicker({ formatDate: "YYYY-NM-DW|ND", isRTL: !0 });




    //jdate & gdate attributes
    $("#pdp-data-jdate").persianDatepicker({
        onSelect: function () {
            alert($("#pdp-data-jdate").attr("data-gdate"));
        }
    });
    $("#pdp-data-gdate").persianDatepicker({
        showGregorianDate: true,
        onSelect: function () {
            alert($("#pdp-data-gdate").attr("data-jdate"));
        }
    });


    //Gregorian date
    $("#pdpGregorian").persianDatepicker({ showGregorianDate: true });

    // jDateFuctions
    // var jdf = new jDateFunctions();
    // var pd = new persianDate();
    // $("#pdpjdf-1").persianDatepicker({
    //     onSelect: function () {
    //         $("#pdpjdf-1").val(jdf.getJulianDayFromPersian(pd.parse($("#pdpjdf-1").val())));
    //         $("#pdpjdf-2").val(jdf.getLastDayOfPersianMonth(pd.parse($("#pdpjdf-1").val())));
    //         $("#pdpjdf-3").val(jdf.getPCalendarDate($("#pdpjdf-1").val()));
    //     }
    // });


    // //convert jalali date to miladi
    // $("#year, #month, #day").on("change", function () {
    //     $("#month").val() > 6 ? $("#day-31").hide() : $("#day-31").show();;
    //     showConverted();
    // });

    // $("#year").keyup(showConverted);
    //
    // function showConverted() {
    //     try{
    //         var pd = new persianDate();
    //         pd.year = parseInt($("#year").val());
    //         pd.month = parseInt($("#month").val());
    //         pd.date = parseInt($("#day").val());
    //
    //         var jdf = new jDateFunctions();
    //         $("#converted").html("Gregorian :  " + jdf.getGDate(pd)._toString("YYYY/MM/DD") + "     [" + jdf.getGDate(pd) + "]<br />Julian:  " + jdf.getJulianDayFromPersian(pd));
    //
    //     } catch (e) {
    //         $("#converted").html("Enter the year correctly!");
    //     }
    // }


    //startDate is tomarrow
    var p = new persianDate();
    $("#pdpStartDateTomarrow").persianDatepicker({ startDate: p.now().addDay(1).toString("YYYY/MM/DD"), endDate: p.now().addDay(4).toString("YYYY/MM/DD") });


});

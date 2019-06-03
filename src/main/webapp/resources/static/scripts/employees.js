$(document).ready(function () {
    $(".extendedGuideInfo").hide();
});


function posChanged() {

    var pos = $("#posSelect option:selected").val();

    $.ajax({
        url:'employee/position',
        type:'GET',
        data:{
            position:pos
        },
        success: function (response) {
            $('#main-div').html(response);
        },
        complete: function (data) {
            $("#posSelect").val(pos);
            if (pos == "Guide") {
                $("#guideSearch").show();
                $(".extendedGuideInfo").show();
            } else if (pos == "") {
                $("#guideSearch").hide();
                $(".extendedGuideInfo").hide();
            } else {
                $("#guideSearch").hide();
            }
        }
    })
};

function dateChanged() {

    var startDateOrigin = $("#dateStartSelect").val();
    var endDateOrigin = $("#dateFinishSelect").val();

    if (startDateOrigin != null && endDateOrigin != null) {

        var date1 = new Date(startDateOrigin);
        var date2 = new Date(endDateOrigin);

        if (date2 > date1) {

            var startDate = startDateOrigin.replace('T', ' ');
            var endDate = endDateOrigin.replace('T', ' ');

            $.ajax({
                url: 'employee/free',
                type: 'GET',
                data: {
                    from: startDate,
                    to: endDate
                },
                success: function (response) {
                    $('#main-div').html(response);
                },
                complete: function (data) {
                    $("#dateStartSelect").val(startDateOrigin);
                    $("#dateFinishSelect").val(endDateOrigin);
                }
            })
        } else {

            window.alert("All date boxes must be filled.\nSecond date box must contain bigger date value.");
            $("#dateStartSelect").val("");
            $("#dateFinishSelect").val("");

        }
    } else {

        window.alert("Incorrect date input.\nRequired: [mm/dd/yyyy hh:mm p]");
        $("#dateStartSelect").val("");
        $("#dateFinishSelect").val("");

    }

};

function clearDates() {
    $("#dateStartSelect").val('');
    $("#dateFinishSelect").val('');
    $.ajax({
        url: 'employee/position',
        type: 'GET',
        data: {
            position: "Guide7"
        },
        success: function (data) {
            $('#main-div').html(data);
        }
    })
};

function getWorkTime(elementId) {

    var id = elementId.substring(21);

    var startDateOrigin = $("#dateStartSelect-" + id).val();
    var endDateOrigin = $("#dateFinishSelect-" + id).val();

    if (startDateOrigin != null && endDateOrigin != null) {

        var date1 = new Date(startDateOrigin);
        var date2 = new Date(endDateOrigin);

        if (date1 < date2) {

            var startDate = startDateOrigin.replace('T', ' ');
            var endDate = endDateOrigin.replace('T', ' ');

            $.ajax({
                url: 'employee/getWorkTime',
                type: 'GET',
                data: {
                    id: id,
                    from: startDate,
                    to: endDate
                },
                success: function (data) {
                    $("#workTime-" + id).text("Work time: " + data);
                }
            })
        } else {

            window.alert("All date boxes must be filled.\nSecond date box must contain bigger date value.");
            $("#dateStartSelect").val("");
            $("#dateFinishSelect").val("");

        }
    } else {

        window.alert("Incorrect date input.\nRequired: [mm/dd/yyyy hh:mm p]");
        $("#dateStartSelect").val("");
        $("#dateFinishSelect").val("");

    }
};

function getExcursionsCount(elementId) {
    var id = elementId.substring(22);
    $.ajax({
        url: 'employee/getExcursionsCount',
        type: 'GET',
        data: {
            id: id
        },
        success: function (data) {
            $("#excursionsCount-" + id).text("Excursions done: " + data);
        }
    })
};
function dateChanged() {

    var startDateOrigin = $("#dateStartSelect").val();
    var endDateOrigin = $("#dateFinishSelect").val();

    if (startDateOrigin!=null && endDateOrigin != null) {
        var date1 = new Date(startDateOrigin);
        var date2 = new Date(endDateOrigin);

        if (date1 < date2) {

            var startDate = startDateOrigin.replace('T', ' ');
            var endDate = endDateOrigin.replace('T', ' ');

            $.ajax({
                url: 'excursion/getAvailable',
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
    $("#dateStartSelect").val("");
    $("#dateFinishSelect").val("");
    $.ajax({
        url: 'excursion/getAvailable',
        type: 'GET',
        data: {
            from: "all",
            to: "all"
        },
        success: function (data) {
            $('#main-div').html(data);
        }
    })
};
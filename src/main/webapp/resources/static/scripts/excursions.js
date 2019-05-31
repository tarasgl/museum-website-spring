function dateChanged() {

    var startDateOrigin = $("#dateStartSelect").val();
    var endDateOrigin = $("#dateFinishSelect").val();
    if (startDateOrigin!=null && endDateOrigin != null) {
        var startDate = startDateOrigin.replace('T', ' ');
        var endDate = endDateOrigin.replace('T', ' ');

        if (startDate && endDate) {
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
        }
    }

};

function clearDates() {
    $("#dateStartSelect").val('');
    $("#dateFinishSelect").val('');
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
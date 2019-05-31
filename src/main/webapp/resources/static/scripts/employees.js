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
        }
    })
};

function dateChanged() {

    var startDateOrigin = $("#dateStartSelect").val();
    var endDateOrigin = $("#dateFinishSelect").val();
    var startDate = startDateOrigin.replace('T', ' ');
    var endDate = endDateOrigin.replace('T', ' ');

    if (startDate && endDate) {
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
    }

};

function clearDates() {
    $("#dateStartSelect").val('');
    $("#dateFinishSelect").val('');
    $.ajax({
        url: 'employee/position',
        type: 'GET',
        data: {
            position: "all"
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
            console.log(data);
            $("#excursionsCount-" + id).text("Excursions done: " + data);
        }
    })
};
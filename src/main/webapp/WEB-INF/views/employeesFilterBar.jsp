<div id="filters" class="row container-fluid filter-bar">
    <div class="col-md-1"></div>
    <select id="posSelect" onchange="posChanged()">
        <option value="">All</option>
        <option value="Manager">Manager</option>
        <option value="Guide">Guide</option>
    </select>
    <label style="margin-left: 30px">From</label>
    <input id="dateStartSelect" type="datetime-local" name="dateSelect" style="margin-left: 20px"
           min="2000-06-07T00:00" max="2060-06-14T00:00" required>
    <label style="margin-left: 30px">To</label>
    <input id="dateFinishSelect" type="datetime-local" name="dateSelect" style="margin-left: 20px"
           min="2000-06-07T00:00" max="2060-06-14T00:00" required>
    <button style="margin-left: 20px" onclick="dateChanged()">Find free guides</button>
    <button style="margin-left: 20px" onclick="clearDates()">Clear dates</button>
</div>
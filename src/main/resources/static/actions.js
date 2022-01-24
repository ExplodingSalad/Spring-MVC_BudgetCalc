function calcBudget() {
    const table = document.getElementById("mainTable");
    const jsonBody = [];

    for (let i = 1; i < table.rows.length; i++) {
        const jsonItem = {};

        jsonItem ["name"] = table.rows[i].cells[0].firstChild.value;
        jsonItem ["category"] = table.rows[i].cells[1].firstChild.value;
        jsonItem ["amount"] = parseFloat(table.rows[i].cells[2].firstChild.value);

        jsonBody.push(jsonItem);
    }

    $.ajax({
        'type': 'POST',
        'url': '/home',
        'contentType': 'application/json',
        'data': JSON.stringify(jsonBody),
        'success': function(response)
        {
            console.log(response);
            // redirect browser to new location
            $("body").html(response);
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on saving appointment:', xhr, status, error);
            // display error message to the user
        }
    });

}

function removeRow() {
    try {
        var table = document.getElementById("mainTable");
        var rowCount = table.rows.length;
        table.deleteRow(rowCount - 1)
    } catch (e) {
        alert("Cannot Delete Row")
    }
}

function addRow() {
    var table = document.getElementById("mainTable");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("input");
    element1.id = "expenseNameTD";
    element1.type = "text";
    element1.placeholder = "Expense Name"
    cell1.appendChild(element1);

    var cell2 = row.insertCell(1);
    var element2 = document.createElement("input");
    element2.id = "expenseCategoryTD";
    element2.type = "text"
    element2.placeholder = "Expense Category"
    cell2.appendChild(element2);

    var cell3 = row.insertCell(2);
    var element3 = document.createElement("input");
    element3.id = "expenseAmountTD";
    element3.type = "number";
    element3.placeholder = "Amount"
    cell3.appendChild(element3);

}
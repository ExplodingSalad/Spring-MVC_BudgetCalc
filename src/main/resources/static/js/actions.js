function calcBudget() {

    clearResultArea();

    const table = document.getElementById("mainTable");
    const jsonBody = [];

    for (let i = 1; i < table.rows.length; i++) {
        const jsonItem = {};

        jsonItem ["name"] = table.rows[i].cells[0].firstChild.value;
        jsonItem ["category"] = table.rows[i].cells[1].firstChild.value;
        jsonItem ["amount"] = parseFloat(table.rows[i].cells[2].firstChild.value);

        jsonBody.push(jsonItem);
    }
    sendAPIRequest(jsonBody);
}

function sendAPIRequest(jsonBody) {
    $.ajax({
        'type': 'POST',
        'url': '/api/results',
        'contentType': 'application/json',
        'data': JSON.stringify(jsonBody),
        'success': function(response)
        {
            displayResponse(response);
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on submitting API request:', xhr, status, error);
        }
    });
}

// this method needs some serious rework lol
function displayResponse(response) {

    const resultArea = document.getElementById("resultContainer"),
        tbl = document.createElement("table"),
        tblHead = document.createElement("thead"),
        tblBody = document.createElement("tbody"),
        title = document.createElement("a");
    tbl.id = "resultTable";
    title.text = "Result";
    title.className = "titles";

    let map = new Map(Object.entries(response));

    /** Create Header Row **/
    const tblHeadRow = tblHead.insertRow();
    const tblHeadRowCell1 = document.createElement("th");
    const tblHeadRowCell2 = document.createElement("th");
    tblHeadRow.append(tblHeadRowCell1, tblHeadRowCell2);
    tblHeadRowCell1.appendChild(document.createTextNode("Category"));
    tblHeadRowCell2.appendChild(document.createTextNode("Amount"));

    /** Insert Dynamic table rows in the table body */
    for (let i = 0; i < map.size; i++) {
        const tr = tblBody.insertRow();
        for (let j = 0; j < 2; j++) {
            const td = tr.insertCell();
            if (j === 0) {
                td.appendChild(document.createTextNode(Array.from(map.keys())[i]));
            } else if (j === 1) {
                td.appendChild(document.createTextNode(map.get(Array.from(map.keys())[i])));
            }
        }
    }
    tbl.appendChild(tblHead);
    tbl.appendChild(tblBody);

    resultArea.appendChild(title);
    resultArea.appendChild(tbl);
    resultArea.style.visibility = 'visible';
}

function clearResultArea() {

    let resultArea = document.getElementById("resultContainer");
    if (resultArea != null) {
        resultArea.innerHTML = '';
    }

}

function removeRow() {
    try {
        let table = document.getElementById("mainTable");
        let rowCount = table.rows.length;
        if (rowCount > 2) {
            table.deleteRow(rowCount - 1)
        }

    } catch (e) {
        alert("Cannot Delete Row")
    }
}

function addRow() {
    let table = document.getElementById("mainTable");

    let rowCount = table.rows.length;
    let row = table.insertRow(rowCount);

    let cell1 = row.insertCell(0);
    let element1 = document.createElement("input");
    element1.id = "expenseNameTD";
    element1.type = "text";
    element1.placeholder = "Expense Name"
    cell1.appendChild(element1);

    let cell2 = row.insertCell(1);
    let element2 = document.createElement("input");
    element2.id = "expenseCategoryTD";
    element2.type = "text"
    element2.placeholder = "Expense Category"
    cell2.appendChild(element2);

    let cell3 = row.insertCell(2);
    let element3 = document.createElement("input");
    element3.id = "expenseAmountTD";
    element3.type = "number";
    element3.placeholder = "Amount"
    cell3.appendChild(element3);
}
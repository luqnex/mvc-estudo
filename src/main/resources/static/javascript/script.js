function handleCheckboxClick(checkbox) {
    let todoId = checkbox.id;
    let isChecked = checkbox.checked;

    console.log("todoId: " + todoId)
    console.log("isChecked: " + isChecked)

     fetch('/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: todoId,
        })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function handleCreate() {
    var input = document.getElementById("input-create")

    var value = input.value;

    console.log(value)

    fetch('/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: value,
        })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);

        document.location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function handleDelete(id) {
    console.log("id: ", id)

    fetch('/delete', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id,
        })
    })
    .then(data => {
        document.location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
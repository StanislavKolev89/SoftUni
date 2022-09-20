function deleteByEmail() {
    let table = Array.from(document.querySelector('tbody').children);

    let input = document.getElementsByName('email')[0];
    let resultArea = document.getElementById('result');
    let deleted = false;

    let searchedEmail = input.value;
    for (let row of table) {
        if (row.children[1].textContent == searchedEmail) {
            row.remove();
              deleted = true;
        }
    }
    if (deleted) {
        resultArea.textContent = 'Deleted.'
    } else {
        resultArea.textContent = 'Not found.';
    }

}
function deleteAll() {

    let table = Array.from(document.querySelector('tbody').children);
    for (let row of table) {
            row.remove();    
    }
}

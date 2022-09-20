function focused() {
    let sections = Array.from(document.querySelectorAll('input'));
    sections.forEach(element => {
        element.addEventListener('focus', changeBackground);
        element.addEventListener('blur', restore);
    });

    function changeBackground(event) {
        event.target.parentNode.className = 'focused';
    }
    function restore(event) {
        event.target.parentNode.className = 'blur';
    }
}
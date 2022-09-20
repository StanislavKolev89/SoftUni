function lockedProfile() {
    let profiles = Array.from(document.querySelectorAll('.profile button'));
    profiles.forEach(e => e.addEventListener('click', onToggle));
    function onToggle(e) {
        let obj = e.target.parentElement;
        let isActive = obj.querySelector('input[type="radio"][value="unlock"]').checked;

        if (isActive) {
            let hiddenFields = obj.querySelector('div');
            if (e.target.textContent == "Show more") {
                hiddenFields.style.display = 'block';
                e.target.textContent = 'Hide it';
            } else {
                hiddenFields.style.display = '';
                e.target.textContent = 'Show more';
            }
        }
    }
}
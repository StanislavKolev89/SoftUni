function attachGradientEvents() {
    let box = document.getElementById('gradient');

    box.addEventListener('mousemove', gradientMove);
    box.addEventListener('mouseout', gradientOut);


    function gradientMove(event) {
        let power = event.offsetX / (event.target.clientWidth - 1);
        power = Math.trunc(power * 100);
        document.getElementById('result').textContent = power + '%';
    }
    function gradientOut(event) {
        document.getElementById('result').textContent = '';
    }
}
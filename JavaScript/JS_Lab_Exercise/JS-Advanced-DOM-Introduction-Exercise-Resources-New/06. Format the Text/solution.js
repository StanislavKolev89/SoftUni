function solve() {
  let textData = document.getElementsByTagName('textarea');

  let textArray = textData[0].value.split('. ');
  let counts = Math.ceil(textArray.length / 3);
  let result = "";
  for (let i = 0; i < counts; i++) {
    result += '<p>';
    result += textArray.length > 3 ? textArray.splice(0, 3).join('.')+'.': textArray.join(''); 
    result += '</p>';
  }

  let output = document.getElementById('output');
  output.innerHTML = result;
}
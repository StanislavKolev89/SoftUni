function solve() {
    let taskArea = document.getElementById('task');
    let descArea = document.getElementById('description');
    let dueDateArea = document.getElementById('date');
    let addBTN = document.getElementById('add');
    addBTN.addEventListener('click', moveToOpenSection);

    function moveToOpenSection(e){
        e.preventDefault();

        if(taskArea.value !=='' && descArea!=='' && dueDateArea.value!==''){

            let article = document.createElement('article');

            let h3 = document.createElement('h3');
            h3.textContent = taskArea.value;
            article.appendChild(h3);

            let p1 = document.createElement('p');
            p1.textContent ='Description: '+ descArea.value;
            article.appendChild(p1);

            let p2 = document.createElement('p');
            p2.textContent = 'Due Date: '+dueDateArea.value;
            article.appendChild(p2);

            let div = document.createElement('div');
            div.classList.add("flex");

            let startBTN = document.createElement('button');
            startBTN.classList.add("green");
            startBTN.textContent = "Start";
            div.appendChild(startBTN);

            let delBTN = document.createElement('button');
            delBTN.classList.add('red');
            delBTN.textContent = "Delete";
            delBTN.addEventListener('click',deleteArticle);
            div.appendChild(delBTN);
         
            startBTN.addEventListener('click', moveToInProgress.bind(null,h3.textContent,p1.textContent,p2.textContent));
            article.appendChild(div);
        
        let h1inOrange = document.getElementsByClassName('orange')[0];
        let sectionOrange = Array.from(h1inOrange.parentElement.parentElement.querySelectorAll('div'));
        let openSection = sectionOrange[1];
        openSection.appendChild(article);

        taskArea.value = '';
        descArea.value = '';
        dueDateArea.value = '';

        }
    
    }

    function moveToInProgress(h33,p11,p22,e){
        let articleToRemove = e.target.parentElement.parentElement;
        articleToRemove.remove();
        let article = document.createElement('article');

        let h3 = document.createElement('h3');
        h3.textContent = h33;
        article.appendChild(h3);

        let p1 = document.createElement('p');
        p1.textContent = p11;
        article.appendChild(p1);

        let p2 = document.createElement('p');
        p2.textContent = p22;
        article.appendChild(p2);

        let div = document.createElement('div');
        div.classList.add("flex");
        let delBTN = document.createElement('button');
        delBTN.classList.add("red");
        delBTN.textContent = "Delete";
        delBTN.addEventListener('click',deleteArticle);
        div.appendChild(delBTN);
        let finishBTN = document.createElement('button');
        finishBTN.classList.add("orange");
        finishBTN.textContent = "Finish";
        div.appendChild(finishBTN);
        finishBTN.addEventListener('click', moveToComplete.bind(null, h3.textContent,p1.textContent,p2.textContent));;
        article.appendChild(div);

        let divToAppendTheArticle = document.getElementById('in-progress');
        divToAppendTheArticle.appendChild(article);
       
    }

    function moveToComplete(h33,p11,p22,e){
        let articleToRemove = e.target.parentElement.parentElement;
        articleToRemove.remove();
         let h1inGreen = document.getElementsByClassName('green')[0];
        let sectionGreen = Array.from(h1inGreen.parentElement.parentElement.querySelectorAll('div'));
        let openSection = sectionGreen[1];

        let article = document.createElement('article');

        let h3 = document.createElement('h3');
        h3.textContent = h33;
        article.appendChild(h3);

        let p1 = document.createElement('p');
        p1.textContent ='Description: '+ p11;
        article.appendChild(p1);

        let p2 = document.createElement('p');
        p2.textContent = 'Due Date: '+p22;
        article.appendChild(p2);
        openSection.appendChild(article);
    }
  
function deleteArticle(e){
    let article = e.target.parentElement.parentElement;
    article.remove();
 }
}
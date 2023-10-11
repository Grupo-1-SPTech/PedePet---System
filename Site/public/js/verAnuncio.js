const optionMenu3 = document.querySelector('.select-menu3');
    selectBtn3 = optionMenu3.querySelector('.select-btn3');
    options3 = optionMenu3.querySelectorAll('.option3');
    sBtn_text3 = optionMenu3.querySelector('.sBtn-text3');

    selectBtn3.addEventListener('click', () => optionMenu3.classList.toggle('active3'))

    options3.forEach(option3 => {
        option3.addEventListener('click', () => {
            let selectedOption3 = option3.querySelector(".option-text3").innerText;
            sBtn_text3.innerText = selectedOption3;
            cadastroUserOBJT3.residentes = selectedOption3; // valor selecionado pelo usuário

            optionMenu3.classList.remove('active3')
        })
    });
// 날짜 가져오기
let today = new Date();
let year = today.getFullYear();
let month = today.getMonth() + 1; // getMonth(); 0부터 시작
let day = today.getDate();
let dayOfWeek = today.getDay();
switch (dayOfWeek) {
    case 0: dayOfWeek = "일요일"; break;
    case 1: dayOfWeek = "월요일"; break;
    case 2: dayOfWeek = "화요일"; break;
    case 3: dayOfWeek = "수요일"; break;
    case 4: dayOfWeek = "목요일"; break;
    case 5: dayOfWeek = "금요일"; break;
    case 6: dayOfWeek = "토요일"; break;
}
today = `${year}년 ${month}월 ${day}일 ${dayOfWeek}`;
document.getElementById('date').innerText = today;

// + 버튼 누르면 할일 내용, 삭제 및 완료 버튼 추가되도록
document.getElementById('addTodo').addEventListener('click', addTodo);
let list = document.getElementById('list');

function addTodo() {
    let text = document.getElementById('inputfield').value;
    let data = `
        <li class="contentList">
            <span class="todoText">${text}</span>
            <input type="button" class="deletebtn" value="삭제">
            <input type="button" class="donebtn" value="완료">
        </li>
    `;

    list.insertAdjacentHTML('beforeend', data);
    document.getElementById('listForm').reset();
}

// 전체 삭제 버튼
document.getElementById('clear').addEventListener('click', clearTodo);

function clearTodo() {
    document.getElementById('list').innerHTML = '';
}

// 각 투두 옆에 있는 삭제 버튼 누르면 해당 투두 삭제됨
// let delbtns = document.getElementsByClassName('deleteTodo');
// let contentList = document.getElementsByClassName('contentList');

// deleteOne();

// function deleteOne() {
//     let delbtns = document.getElementsByClassName('deleteTodo');
//     let contentList = document.getElementsByClassName('contentList');

//     for (let i = 0; i < delbtns.length; ++i) {
//         delbtns[i].addEventListener('click', function() {
//             contentList[i].remove();
//         });
//     }
// }

/*
위 코드는 모든 삭제 버튼에 대한 이벤트 리스너가 추가되기 때문에 삭제 버튼을 클릭해도 반응하지 않음 
삭제 버튼에 대한 이벤트 리스너를 각각 지정하는 대신에 부모 요소에 이벤트 리스너를 추가하고 이벤트를 위임하는 방법을 사용
 */

list.addEventListener('click', function(event) {
    if (event.target.classList.contains('deletebtn')) {
        // target: 삭제버튼
        // 삭제버튼의 부모 -> <li>
        event.target.parentElement.remove();
    }
});

// 각 투두 옆에 있는 완료 버튼 누르면 해당 투두 줄쳐짐
list.addEventListener('click', function(event) {
    if (event.target.classList.contains('donebtn')) {
        // 완료버튼의 이전 형제 노드값: 삭제버튼
        let delbtn = event.target.previousElementSibling;
        // 삭제버튼의 이전형제 노드값: 텍스트값을 담은 <span>태그
        // span태그에 줄긋기 적용
        delbtn.previousElementSibling.style.textDecoration = 'line-through';

        // 완료 되면 marker의 색깔 바꾸기 - 수정 필요
        // let todolist = event.target.parentElement;
        // let marker = window.getComputedStyle(todolist, '::marker');//.style.color = 'rgb(189, 0, 241)';
    }
});






document.getElementById("joinBtn").addEventListener("click", function () {
    const memberid = document.getElementById("memberid").value.trim();
    if (memberid.length < 3 || memberid.length > 10) {
      alert("아이디는 3 ~ 10글자로 입력해주세요");
      document.getElementById("memberid").select();
      event.preventDefault();
      return;
    }

    const memberpw = document.getElementById("memberpw").value.trim();
    if (memberpw.length < 3 || memberpw.length > 10) {
      alert("비밀번호는 3 ~ 10글자로 입력해주세요");
      document.getElementById("memberpw").select();
      event.preventDefault();
      return;
    }

    const pwcheck = document.getElementById("check-memberpw").value.trim();
    if (memberpw != pwcheck) {
      alert("비밀번호가 일치하지 않습니다");
      document.getElementById("check-memberpw").select();
      event.preventDefault();
      return;
    }

    const membername = document.getElementById("membername").value.trim();
    if (membername.length == 0) {
      alert("이름을 입력하세요");
      document.getElementById("membername").select();
      event.preventDefault();
      return;
    }
  });
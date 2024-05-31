document.getElementById("loginBtn").addEventListener("click", function () {
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
  });
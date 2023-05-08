const findtype = document.querySelector("#findtype"); // 프론트 jsp파일에서 게시판 버튼 id 가져오기
const findkey = document.querySelector("#findkey"); //
const findbtn = document.querySelector("#findbtn"); //

findbtn?.addEventListener('click',()=>{  // 컨트롤러에 있는 변수들 가져와서

    if(findkey.value=='') { //검색을 아무것도 안하면 경고창만 뜨게하기
        alert('검색어를 입력하세요!!');
        return;
    }

   let query= `/board/find?ftype=${findtype.value}&fkey=${findkey.value}&cpg=1`;
   //board/find 주소 창이 이렇게 find가 되어야한다.
   location.href=query;

});









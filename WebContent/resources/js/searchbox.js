document.addEventListener('DOMContentLoaded', function(){
    document.querySelector("#searchicon").addEventListener("click", function(e){
    if ( document.querySelector('#searchicon').classList.contains('on') ){
        //메뉴닫힘
        document.querySelector('#searchicon').classList.remove('on');
        document.querySelector('#searchbox').classList.remove('fa-times')
        document.querySelector('#searchbox').classList.add('fa-bars');
        document.querySelector('#searchbox').style.display = 'none';
        document.querySelector('#searchbt').style.display = 'none';

        //페이지 스크롤 락 해제
        document.querySelector('#dimmed').remove();
    } else {
        //메뉴펼침
        document.querySelector('#searchicon').classList.add('on');
        document.querySelector('#searchbox').classList.remove('fa-bars');
        document.querySelector('#searchbox').classList.add('fa-times');
        document.querySelector('#searchbox').style.display = 'flex'; 
        document.querySelector('#searchbt').style.display = 'flex';          

    }
    });
});
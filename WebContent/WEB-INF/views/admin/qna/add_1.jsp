<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>

<head>
  <style>
    @import url(css/관리자메인.css);
    @import url(css/관리자사이드.css);
    @import url(css/관리자리뷰답글.css);
  </style>
</head>

<body>
  <nav>
    <!--사이드바에 들어갈 내용들-->
    <div class="sidecon">

      <div class="admin">
        <input type="radio" name="jaekwon" id="side0">
        <label for="side0"><i class="fas fa-home"></i><a href="#">HOME</a></label>

        <!--관리자-->
        <input type="radio" name="jaekwon" id="side1">
        <label for="side1"><i class="far fa-user"></i><a>관리자</a></label>
        <div>
          <div class="submenu"><a href="#">관리자 등록</a></div>
          <div class="submenu"><a href="#">관리자 수정/삭제</a></div>
        </div>

        <!--회원관리-->
        <input type="radio" name="jaekwon" id="side2">
        <label for="side2"><i class="far fa-user"></i><a>회원관리</a></label>
        <div>
          <div class="submenu"><a href="#">회원탈퇴</a></div>
          <div class="submenu"><a href="#">포인트수정</a></div>
        </div>

        <!--상품관리-->
        <input type="radio" name="jaekwon" id="side3">
        <label for="side3"><i class="fas fa-tasks"></i><a>상품관리</a></label>
        <div>
          <div class="submenu"><a href="#">상품 등록</a></div>
          <div class="submenu"><a href="#">상품 수정/삭제</a></div>
        </div>

        <!--주문관리-->
        <input type="radio" name="jaekwon" id="side4">
        <label for="side4"><i class="far fa-list-alt"></i><a>주문관리</a></label>
        <div>
          <div class="submenu"><a href="#">주문 목록</a></div>
        </div>

        <!--리뷰,댓글-->
        <input type="radio" name="jaekwon" id="side5">
        <label for="side5"><i class="far fa-comment"></i><a>리뷰/문의</a></label>
        <div class="sub">
          <div class="submenu"><a href="#">상품리뷰확인</a></div>
          <div class="submenu"><a href="#">상품문의확인</a></div>
        </div>

        <!--기타-->
        <input type="radio" name="jaekwon" id="side6">
        <label for="side6"><i class="far fa-calendar-alt"></i><a>기타</a></label>
        <div class="sub">
          <div class="submenu"><a href="#">공지사항/이벤트 리스트</a></div>
          <div class="submenu"><a href="#">공지사항/이벤트 작성</a></div>
        </div>

        <input type="button" class="title_a" value="로그아웃">

      </div>
    </div>
  </nav>

  <section>
    <div class="main">
      <div class="goods">

        <div class="">
            <table class="">
                <tbody>
                    <tr>
                        <th class="">작성자</th>
                        <td class=""><input type="text" value="관리자"></td>
                    </tr>
                    <tr>
                        <th class="">비밀번호</th>
                        <td class=""><input type="password" placeholder="비밀번호를 입력해주세요 " style="height: 25px;"></td>
                    </tr>
                    <tr>
                        <th class="">고객명</th>
                        <td class=""><input type="text" value="고객명"></td>
                    </tr>
                    <tr>
                        <th class="">문의내용</th>
                        <td class=""><a href="#"><input type="text" value="클라이언트 문의내용이 들어와있음"></a></td>
                    </tr>
                </tbody>
            </table>
<!-- 답글 내용 -->
            <div class="">
                <textarea cols="150%" rows="10" placeholder="내용을입력하시오" style="border:1px solid #ccc;"></textarea>
                <button type="submit">작성</button>

            </div>
            </div>
        
        </div>
      </div>
  </section>

</body>

</html>
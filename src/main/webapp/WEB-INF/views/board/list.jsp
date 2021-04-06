<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<button id='regBtn' type="button" class="btn btn-primary btn-xs pull-right">Register New Board</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">

                    <tr>
                        <th>#번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>수정일</th>
                    </tr>


					<c:forEach var="board" items="${list}">
						<tr>
							<td>${board.bno}</td>

							<td>
							    <a class='move' href="/board/get?bno=${board.bno}">
									${board.title}
							    </a>
							</td>

							<td>${board.writer}</td>
							<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${board.regDate}" /></td>
							<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${board.updateDate}" /></td>
						</tr>
					</c:forEach>
				</table>

				<div class='pull-right'>
                    <ul class="pagination">
                        <c:if test="${pageMaker.prev}">
                            <li class="paginate_button previous"><a
                                href="${pageMaker.startPage -1}">Previous</a></li>
                        </c:if>

                        <c:forEach var="num" begin="${pageMaker.startPage}"
                            end="${pageMaker.endPage}">
                            <li class="paginate_button  ${pageMaker.cri.pageNum == num ? 'active':''} ">
                                <a href="${num}">${num}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${pageMaker.next}">
                            <li class="paginate_button next"><a
                                href="${pageMaker.endPage +1 }">Next</a></li>
                        </c:if>
                   </ul>
                </div>
                <!--  end Pagination -->

                <form id='actionForm' action="/board/list" method='get'>
                    <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
                    <input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
                </form>


				<!-- Modal  추가 -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">처리가 완료되었습니다.</div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default"
                                    data-dismiss="modal">Close</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
</div>
<!-- /.row -->

<script>

$(document).ready(function() {

    var result = "${result}";

    checkModal(result);

    history.replaceState({}, null, null);

    function checkModal(result) {

        if (result === '' || history.state) {
            return;
        }

        if (result === 'regSuccess') {
            $(".modal-body").html("게시글이 등록되었습니다.");
        } else if (result === 'modSuccess') {
            $(".modal-body").html("게시글이 수정되었습니다.");
        } else if (result === 'delSuccess') {
            $(".modal-body").html("게시글이 삭제되었습니다.");
        }

        $("#myModal").modal("show");
    }

    //게시물 등록 버튼 클릭 이벤트
    document.getElementById('regBtn').addEventListener('click', e => {
        location.href = '/board/register';
    });

    //페이지 버튼 클릭 이벤트
    const actionForm = document.getElementById("actionForm");

    document.querySelector(".pagination").addEventListener("click", e => {
        e.preventDefault();
        console.log('click');
        const pageInput = actionForm.querySelector("input[name='pageNum']");

        pageInput.value = e.target.getAttribute('href');

        actionForm.submit();
    });


});
</script>



<%@include file="../includes/footer.jsp"%>

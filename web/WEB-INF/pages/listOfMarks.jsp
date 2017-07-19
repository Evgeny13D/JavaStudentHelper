<%@ page import="java.util.List" %>
<%@ page import="static java.lang.String.format" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <%--<link rel="stylesheet" href="chooseAction.css">--%>
    <link rel="stylesheet" href="../resources/css/listOfStudent.css">
    <!-- <link rel="stylesheet" href="theme.css"> -->


</head>

<body>
<div class="title">
    <p><span class="pink">L</span>ist of <span class="pink">M</span>arks</p>
</div>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Study id</th>
        <th>Student id</th>
        <th>DATE</th>
        <th>PROFESSOR</th>
        <th>Mark</th>
        <th>Comments</th>
        <th class="but"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="mark" items="${marksList}">
        <tr>
            <td>${mark.id}</td>
            <td>
                <div class="modal-instance">
                    <a class="btn_in_td modal-trigger" href="#">${mark.study_id}</a>
                    <div class="modal-container">
                        <div class="modal-content height--natural">
                            <div class="form-subscribe-1 boxed boxed--lg bg--white">
                                <div class=" text-center">
                                    <p class="lead">
                                        Edit mark
                                    </p>
                                </div>
                                <form class="form--center-submit-button" action="EditMarkController" method="post" id="subForm" data-error="Please fill all fields correctly." data-success="Thanks for signing up! Please check your inbox for confirmation email.">
                                    <div>
                                        <input name="id" value="${mark.id}" hidden/>
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="firstName">Study id</label>
                                        <input id="firstName" name="study_id" type="text" value="${mark.study_id}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="secondName">Student_id</label>
                                        <input class="" id="secondName" name="secondName" type="text" value="${student.secondName}" />
                                    </div>
                                    <div class="input-with-icon" >
                                        <label for="avgMark">Datek</label>
                                        <input id="avgMark" name="date" type="text" value="${mark.date}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="groupNumber">Professor </label>
                                        <input class="" id="groupNumber" name="professor_id" type="text" value="${mark.professor_id}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="groupNumbe">Mark </label>
                                        <input class="" id="groupNumbe" name="mark" type="text" value="${mark.mark}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="groupNumb">Comments </label>
                                        <input class="" id="groupNumb" name="comments" type="text" value="${mark.comments}" />
                                    </div>
                                    <button href="" class="btn1 btn_1" type="submit"><span class="pink">E</span>DIT</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>${mark.student_id}</td>
            <td>${mark.date}</td>
            <td>${mark.professor_id}</td>
            <td>${mark.mark}</td>
            <td>${mark.comments}</td>
            <td class="but">
                <div class="modal-instance">
                    <a class="btn1 modal-trigger" href="#">
                        <span class="btn__text pink">Delete</span>
                    </a>
                    <div class="modal-container">
                        <div class="modal-content bg-white imagebg" data-width="50%" data-height="50%" data-overlay="5">
                            <div class="pos-vertical-center clearfix">
                                <div class="">
                                    <h2><span class="pink">D</span>o you <span class="pink">R</span>eally want to delete this student?</h2>
                                    <p>
                                    <h4>This can lead to a complete loss of information about this student.</h4>
                                    </p>
                                    <a class="btn1 btn_1" href="RemoveMarkController?id=${mark.id}">
                                        <span class="btn__text"><span class="pink">D</span>ELETE</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<section>
    <div>
    </div>
</section>

<table>
    <tbody>
    <tr >
        <td class="btn">
            <div class="but">
                <a href="AddMarkController" class="button_1 box curmudgeon">Add</a>
            </div>
        </td>
        <td class="btn">
            <div class="but">
                <a href="index.jsp" class="button_1 box curmudgeon">Recalculate AVG</a>
            </div>
        </td>
        <td class="btn">
            <div class="but">
                <a href="ChooseAction" class="button_1 box curmudgeon">Back</a>
            </div>
        </td>
    </tr>
    </tbody>
</table>
</body>
<script src="../../resources/js/jquery-2.1.4.min.js"></script>
<script src="../../resources/js/scripts.js"></script>
<%--<script src="js/jquery-2.1.4.min.js"></script>--%>
<%--<script src="js/scripts.js"></script>--%>

</html>

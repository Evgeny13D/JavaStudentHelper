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
    <p><span class="pink">L</span>ist of <span class="pink">S</span>tudents</p>
</div>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Group</th>
        <th class="but"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentsList}">
        <tr>
            <td>${student.id}</td>
            <td>
                <div class="modal-instance">
                    <a class="btn_in_td modal-trigger" href="#">${student.firstName}</a>
                    <div class="modal-container">
                        <div class="modal-content height--natural">
                            <div class="form-subscribe-1 boxed boxed--lg bg--white">
                                <div class=" text-center">
                                    <p class="lead">
                                        Edit student ${student.firstName}
                                    </p>
                                </div>
                                <form class="form--center-submit-button" action="EditStudentController" method="post" id="subForm" data-error="Please fill all fields correctly." data-success="Thanks for signing up! Please check your inbox for confirmation email.">
                                    <div>
                                        <input name="id" value="${student.id}" hidden/>
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="firstName">First Name</label>
                                        <input id="firstName" name="firstName" type="text" value="${student.firstName}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="secondName">Second Name</label>
                                        <input class="" id="secondName" name="secondName" type="text" value="${student.secondName}" />
                                    </div>
                                    <div class="input-with-icon" >
                                        <label for="avgMark">Average Mark</label>
                                        <input id="avgMark" name="avgMark" type="text" value="${student.avgMark}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="groupNumber">Group Number</label>
                                        <input class="" id="groupNumber" name="groupNumber" type="text" value="${student.groupNumber}" />
                                    </div>
                                    <button href="" class="btn1 btn_1" type="submit"><span class="pink">E</span>DIT</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>${student.secondName}</td>
            <td>${student.groupNumber}</td>
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
                                    <a class="btn1 btn_1" href="RemoveServlet?id=${student.id}">
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
                <a href="AddStudentForm" class="button_1 box curmudgeon">Add</a>
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

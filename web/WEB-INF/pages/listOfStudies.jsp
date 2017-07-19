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
    <p><span class="pink">L</span>ist of <span class="pink">S</span>tudies</p>
</div>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Hours</th>
        <th>Professor ID</th>
        <th>Average Mark</th>
        <th class="but"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="study" items="${studiesList}">
        <tr>
            <td>${study.id}</td>
            <td>
                <div class="modal-instance">
                    <a class="btn_in_td modal-trigger" href="#">${study.name}</a>
                    <div class="modal-container">
                        <div class="modal-content height--natural">
                            <div class="form-subscribe-1 boxed boxed--lg bg--white">
                                <div class=" text-center">
                                    <p class="lead">
                                        Edit student ${study.name}
                                    </p>
                                </div>
                                <form class="form--center-submit-button" action="EditStudyController" method="post" id="subForm" data-error="Please fill all fields correctly." data-success="Thanks for signing up! Please check your inbox for confirmation email.">
                                    <div>
                                        <input name="id" value="${study.id}" hidden/>
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="firstName">Name</label>
                                        <input id="firstName" name="name" type="text" value="${study.name}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="secondName">Hours</label>
                                        <input class="" id="secondName" name="hours" type="text" value="${study.hours}" />
                                    </div>
                                    <div class="input-with-icon" >
                                        <label for="avgMark">Professor ID</label>
                                        <input id="avgMark" name="professor_id" type="text" value="${study.professor_id}" />
                                    </div>
                                    <div class="input-with-icon">
                                        <label for="groupNumber">Average Mark</label>
                                        <input class="" id="groupNumber" name="avg_mark" type="text" value="${study.avg_mark}" />
                                    </div>
                                    <button href="" class="btn1 btn_1" type="submit"><span class="pink">E</span>DIT</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>${study.hours}</td>
            <td>${study.professor_id}</td>
            <td>${study.avg_mark}</td>
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
                                    <a class="btn1 btn_1" href="RemoveStudyController?id=${study.id}">
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
                <a href="AddStudyController" class="button_1 box curmudgeon">Add</a>
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

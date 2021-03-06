<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>add student</title>
    <link href="../../resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../../resources/css/addStudentForm.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div>
    <section class="height-100 cover-8">
        <div class="col-md-7 col-sm-5">
            <div class="background-image-holder"><!-- -->
                <img alt="image" src="../resources/images/new.jpg" />
            </div>
        </div>
        <div class="col-md-5 col-sm-7">
            <div class="pos-vertical-center">
                <img class="logo" src="../resources/images/ST.jpg" />
                <div class="text-left">
                    <form method="post">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-with-icon">
                                    <label>Study Id:</label>
                                    <input type="text" name="study_id" placeholder="12" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-with-icon">
                                    <label>Student ID:</label>
                                    <input type="text" name="student_id" placeholder="13" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-with-icon">
                                    <label>Date:</label>
                                    <input type="text" name="date" placeholder="13.12" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-with-icon">
                                    <label>Professor ID:</label>
                                    <input type="text" name="professor_id" placeholder="13" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-with-icon">
                                    <label>Mark:</label>
                                    <input type="text" name="mark" placeholder="10" />
                                </div>
                            </div>
                        </div>
                        <%--<div class="row">--%>
                            <%--<div class="col-sm-12">--%>
                                <%--<div class="input-with-icon">--%>
                                    <%--<label>Comments:</label>--%>
                                    <%--<input type="text" name="comments" placeholder="bla bla" />--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="row">
                            <div class="col-sm-12 text-center">
                                <div class="input-checkbox">
                                    <div class="inner"></div>
                                    <input type="checkbox" />
                                </div>
                                <span class="type--fine-print">I agree to the
                                                <a href="#">terms and conditions</a>
                                </span>
                            </div>
                        </div>
                        <div class="row">
                            <div href="" class="col-sm-12">
                                <button type="submit" class="btn btn--primary">Add Mark</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 text-center-xs">
                    <span class="type--fine-print">&copy; Copyright
                    <span class="update-year">2016</span> Evgeny Kolman for IBA Group - All Rights Reserved</span>
            </div>
        </div>
    </div>
    </footer>
</div>
<script src="../../resources/js/jquery-2.1.4.min.js"></script>
<script src="../../resources/js/scripts.js"></script>
</body>
</html>
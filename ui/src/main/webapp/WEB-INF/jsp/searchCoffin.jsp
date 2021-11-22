<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!doctype html>
    <html lang="en">

    <jsp:include page="util/head.jsp" />

    <body>

        <!-- Preloader -->
        <div id="page-loading-blocs-notifaction" class="page-preloader"></div>
        <!-- Preloader END -->


        <!-- Main container -->
        <div class="page-container">

            <!-- bloc-header -->
            <div class="bloc bgc-prussian-blue none bloc-bg-texture texture-dots d-bloc " id="bloc-header">
                <div class="container bloc-sm">
                    <div class="row">
                        <div class="col">
                            <nav class="navbar navbar-light row navbar-expand-md" role="navigation">
                                <a class="navbar-brand link-style ltc-white" href="index">REST in Peace</a>
                                <button id="nav-toggle" type="button"
                                    class="ml-auto ui-navbar-toggler navbar-toggler border-0 p-0 menu-icon-two-bars"
                                    data-toggle="collapse" data-target=".navbar-28431" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse navbar-28431 special-dropdown-nav">
                                    <ul class="site-navigation nav navbar-nav ml-auto">
                                        <li class="nav-item">
                                            <a href="createcoffin" class="nav-link a-btn ltc-white">Sell a Coffin</a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="searchcoffin" class="nav-link a-btn ltc-white">Coffin Catalogue</a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="index" class="a-btn nav-link"></a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- bloc-header END -->

            <!-- coffin-block -->

            <div class="bloc none l-bloc" id="coffin-block">
                <div class="container bloc-sm">
                    <div class="row">
                        <div class="col-12">
                            <img src="img/lazyload-ph.png" data-src="img/coffin_large.png"
                                class="img-fluid mx-auto d-block img-coffin-lar-style mg-lg none animated fadeInDown animSpeedLazy lazyload"
                                alt="coffin_large" data-appear-anim-style="fadeInDown" />
                            <h2 class="text-lg-left mg-lg mx-auto d-block">
                                Catalogue
                            </h2>
                            <div class="divider-h">
                                <span class="divider"></span>
                            </div>
                        </div>
                    </div>
                    <c:forEach var="record" items="${records}">
                        <div class="row">
                            <div class="col-md-3 col-lg-2">
                                <p>
                                    Name
                                </p>
                            </div>
                            <div class="col-md-3 col-lg-3">
                                <img src="img/lazyload-ph.png" data-src="img/placeholder-image.png"
                                    class="img-fluid mx-auto d-block lazyload" alt="coffn-image" />
                            </div>
                            <div class="col-md-3 col-lg-3">
                                <p class="p-style">
                                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor.
                                    Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur
                                    ridiculus mus.&nbsp;
                                </p>
                            </div>
                            <div class="col-md-3 offset-lg-0 col-lg-1">
                                <p>
                                    100 $
                                </p>
                            </div>
                            <div class="col-md-3">
                                <p class="p-coffin-block-style">
                                    Contact details:<br>Email: something@gmail.com<br>Name: rejgokfroe
                                </p>
                            </div>
                        </div>
                        <div class="divider-h">
                            <span class="divider"></span>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- coffin-block END -->

            <!-- ScrollToTop Button -->
            <a class="bloc-button btn btn-d scrollToTop" onclick="scrollToTarget('1',this)"><span
                    class="fa fa-chevron-up"></span></a>
            <!-- ScrollToTop Button END-->


            <!-- bloc-footer -->
            <div class="bloc l-bloc" id="bloc-footer">
                <div class="container bloc-lg">
                    <div class="row">
                        <div class="col-12 col-11 col-lg-8 offset-lg-2">
                            <div class="divider-h">
                                <span class="divider"></span>
                            </div>
                            <h4 class="mg-md text-center  h4-style">
                                <span><i>"Exercise regularly so that we don&rsquo;t have to use distributed computing
                                        for a
                                        coffin market system"</i></span><br>
                            </h4>
                            <p class="mg-md text-center  p-color">
                                <span>Put X in Team &#169; 2020&nbsp;</span><br>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- bloc-footer END -->

        </div>
        <!-- Main container END -->

        <jsp:include page="util/scripts.jsp" />
        <!-- Additional JS END -->


    </body>

    </html>
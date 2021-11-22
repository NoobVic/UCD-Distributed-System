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

        <!-- bloc-home -->
        <div class="bloc none bloc-fill-screen l-bloc" id="bloc-home">
            <div class="container fill-bloc-top-edge">
                <div class="row header-row">
                    <div class="col">
                        <img class="img-fluid img-style mx-auto d-block animated fadeInDown animSpeedLazy none lazyload"
                            src="img/lazyload-ph.png" data-src="img/coffin_large.png" height="100" width="100"
                            alt="coffin_large" data-appear-anim-style="fadeInDown" />
                        <h1 class="mg-md mx-auto d-block text-lg-center h1-style">
                            REST in Peace
                        </h1>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h3 class="mg-md mx-auto d-block text-lg-center">
                            Welcome to one of the&nbsp;<span class="animSpeedLazy animated flash animLoop04"
                                data-appear-anim-style="flash">largest</span>&nbsp;coffin marketplaces!
                        </h3>
                        <div class="divider-h">
                            <span class="divider"></span>
                        </div>
                        <div class="row">
                            <div class="col">
                                <h4 class="mg-md text-lg-center">
                                    Search coffins if you can't wear a mask properly
                                </h4>
                                <div class="form-group text-lg-center">
                                    <input class="form-control search-bar search-bar-field field-style field-0-style"
                                        placeholder="Search the catalogue..." />
                                </div>
                            </div>
                            <div class="col">
                                <h4 class="mg-md text-lg-center h4-2-style">
                                    Sell one if it is no longer needed :)<br>
                                </h4>
                                <div class="row">
                                    <div class="col">
                                        <div class="text-center">
                                            <a href="createcoffin"
                                                class="btn btn-lg btn-rd btn-prussian-blue btn-sell-style"><span
                                                    class="icon-spacer none fa fa-plus icon-sm icon-white"></span>SELL</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- bloc-home END -->

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
                            <span><i>"Exercise regularly so that we don&rsquo;t have to use distributed computing for a
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

</body>

</html>
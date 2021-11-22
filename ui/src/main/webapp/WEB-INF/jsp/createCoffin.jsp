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

        <!-- create-coffin-block -->
        <div class="bloc none bloc-fill-screen l-bloc" id="create-coffin-block">
            <div class="container fill-bloc-top-edge">
                <div class="row header-row">
                    <div class="col">
                        <img class="img-fluid img-style mx-auto d-block animated fadeInDown animSpeedLazy none lazyload"
                            src="img/lazyload-ph.png" data-src="img/coffin_large.png" height="100" width="100"
                            alt="coffin_large" data-appear-anim-style="fadeInDown" />
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="offset-md-2 col-md-8 offset-lg-1 col-lg-10">
                        <form id="form_42586" action="/createCoffinAction"  enctype='multipart/form-data' method="POST" data-form-type="blocs-form" novalidate class="form-style">
                            <div class="row in-form-row">
                                <div class="offset-md-2 col-md-8 form-column col-lg-6 offset-lg-1">
                                    <div class="form-group user-data">
                                        <label>
                                            Username
                                        </label>
                                        <input id="username_42586" class="form-control sell-user-inputs" required
                                            data-validation-required-message="Please specify your username" name ="username"
                                            placeholder="john" />
                                    </div>
                                </div>
                                <div class="offset-md-2 col-md-8 form-column offset-lg-5 col-lg-6">
                                    <div class="form-group user-data text-lg-left">
                                        <label class="text-lg-center">
                                            Email
                                        </label>
                                        <input id="email_42586" class="form-control sell-user-inputs" type="email"
                                            required placeholder="john@example.com"
                                               name = "email"
                                            data-validation-required-message="Please specify your email address"
                                            data-error-validation-msg="Enter a valid email address" />
                                    </div>
                                </div>
                            </div>
                            <div class="row in-form-row">
                                <div class="offset-md-2 col-md-8 form-column col-lg-6 offset-lg-1">
                                    <div class="form-group user-data">
                                        <label>
                                            Coffin Name
                                        </label>
                                        <input id="coffin_name_42586" class="form-control sell-user-inputs" required
                                               name="coffin_name"
                                            data-validation-required-message="Please specify coffin name"
                                            placeholder="eternal_happiness" />
                                    </div>
                                </div>
                                <div class="offset-md-2 col-md-8 form-column col-lg-6 offset-lg-9">
                                    <label class="text-lg-center">
                                        Price [EUR]
                                    </label>
                                    <div class="form-group user-data">
                                        <input id="coffin_price_42586"
                                            class="form-control number-input sell-user-inputs" required type="number"
                                               name="coffin_price"
                                            placeholder="100" data-validation-required-message="Please set a price" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>
                                    Description<br>
                                </label><textarea id="coffin_description_42586"
                                                  name="coffin_description"
                                    class="form-control sell-user-description" rows="1" cols="50" required
                                    placeholder="Luxurious dark oak body fitted with 1st grade Mulberry silk"
                                    maxlength="200"
                                    data-validation-required-message="Please describe the coffin"></textarea>
                            </div>
                            <div class="text-center">
                                <label for="pictureUpload" class="custom-file-upload">
                                    Image Upload
                                </label>
                                <input type="file" id="pictureUpload" d="pictureUpload" class="" required name="pictureUpload" accept=".jpeg,.png"/>
                            </div> 
                            <div class="form-check checkbox-style form-check-inline">
                                <input class="form-check-input" type="checkbox" id="optin_17554_42586"
                                    data-validation-minchecked-message="Please confirm"
                                    data-validation-minchecked-minchecked="1" name="optin_17554" />
                                <label class="form-check-label">
                                    I am sure that I no longer need my precious coffin
                                </label>
                            </div>
                            <div class="text-center text-lg-center container-div-style">
                                <button
                                    class="bloc-button btn btn-prussian-blue btn-style btn-rd btn-lg btn-style-hover"
                                    type="submit">
                                    <span class="icon-spacer fa fa-check icon-white icon-sm"></span>Create Listing
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- create-coffin-block END -->

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
    <!-- Additional JS END -->


</body>

</html>
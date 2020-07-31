<html>
<head>
    <link type="text/css" href="/css/styles.css" rel="stylesheet"/>
</head>

<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Login please!
    </div>
    <form method="post" action="/login">
        <label for="login">Login
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>

        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>

        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Remember me</label>
        <br>
        <input type="submit" value="Sign Up">
    </form>
</div>
</body>

</html>
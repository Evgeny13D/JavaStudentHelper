/**
 * Created by Evgeny on 4/2/17.
 */

$('.login-input').on('focus', function() {
    $('.login').addClass('focused');
});

$('.login').on('submit', function(e) {
    e.preventDefault();
    $('.login').removeClass('focused').addClass('loading');
});

$(function(){
    //基本提示框
    new jBox('Modal', {
        attach: '#baseShow',
        height: 200,
        overlay:false,//是否覆盖页面(界面只有弹框，背景为灰色)
        title: '打开一个提示框',
        content: '这是一个提示框，你可以按键Esc或点击关闭按钮关闭'
    });

    //移动弹框设置
    new jBox('Modal', {
        attach: '#show',
        width: 350,
        height: 200,
        blockScroll: false,
        animation: 'zoomIn',
        draggable: 'title',
        closeButton: true,
        content: $("#showBox"),
        title: '移动弹框',
        overlay: false,
        reposition: false,
        repositionOnOpen: false
    });
    //ajax弹框效果
    new jBox('Modal', {
        attach: '#showAjax',
        width: 450,
        height: 250,
        closeButton: 'title',
        animation: false,
        title: 'Ajax请求弹框',
        ajax: {
            url: 'get',
            data: {
                id: '1982',
            },
            reload: 'strict',
            setContent: false,
            beforeSend: function() {
                this.setContent('');
                this.setTitle('<div class="ajax-sending">Ajax请求发送中...</div>');
            },
            complete: function(response) {
                this.setTitle('<div class="ajax-complete">AJAX请求完成</div>');
            },
            success: function(response) {
                this.setContent('<div class="ajax-success"> 编号:'+ response.id + '<br/>城市:' + response.name  + '</tt></div>');
            },
            error: function() {
                this.setContent('<div class="ajax-error">抱歉，请求出现错误</div>');
            }
        }
    });

    //鼠标悬停显示内容
    new jBox('Tooltip', {
        attach: '#hover',
        width: 300,
        pointer: 'right:80',
        animation: 'move',
        delayOpen: 0,
        delayClose: 100,
        content: '此框触碰即可打开，移出鼠标后关闭',
        onOpen: function() {
            this.source.removeClass('active').html('Open');
        },
        onClose: function() {
            this.source.removeClass('active').html('Hover me');
        }
    });
});
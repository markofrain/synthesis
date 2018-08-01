# 项目技术综合学习文档

[GitHub地址](https://github.com/markofrain/synthesis)

**重点重点:主要看README!!!!**
**重点重点:主要看README!!!!**
**重点重点:主要看README!!!!**


包含前端技术:

jsp自定义标签

Mustache模板库

treeTable树形表

jquery validate校验

pagination 分页

WdatePicker日期插件

jquery jbox通知插件

zTree js

具体以目录为准!!!


**目录**

<a href="#a1">JS自定义标签</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#a2">自定义tld文件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#a3">自定义tag文件</a><br/>
<a href="#b1">Js Mustache模板引擎</a><br/>
<a href="#c1">jQuery treeTable js</a><br/>
<a href="#d1">jquery DateTimer jeDate时间控件</a><br/>
<a href="#e1">jQuery validate校验框架</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#e2">默认标签校验规则</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#e3">js设置校验规则</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#e4">其他方法级问题</a><br/>
<a href="#f1">zTree js框架</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#f2">基本json使用，一次性加载完毕</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#f3">异步加载</a><br/>
<a href="#g1">Mybatis分页插件PageHelper</a><br/>
<a href="#h1">stephanwagner jbox弹框插件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#h2">基本提示框(全屏)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#h3">移动弹框</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#h4">弹框内容由ajax发起请求并显示</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#h5">鼠标悬停显示信息</a><br/>



<h2 id="a1">JSP自定义标签</h2>
jsp自定义标签可以通过定义tld文件和tag文件来完成
tld是自定义方法标签，可以调用类的静态方法
tag是自定义控件标签，可自定义标签，定义标签属性添加

<h3 id="a2">自定义tld文件</h3>
主要用于对java方法的静态都调用

引用示例:

    <%@ taglib prefix="gbl" uri="/WEB-INF/tlds/stu.tld" %>

对于自定义tld标签需要使用的依赖

```
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>jstl</artifactId>
  <version>1.2</version>
</dependency>
```

tld文件内，主要是方法function，通过java类静态方法的定义和引用，在jsp中通过${}方式输出

例如:<%@ taglib prefix="stu" uri="/WEB-INF/tlds/stu.tld" %>

则可以${stu:method(params)}的方式输出

tld文件的定义

```
<?xml version="1.0" encoding="UTF-8" ?>

<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
        version="2.0">

    <description>JSTL 1.1 Global library</description>
    <display-name>JSTL Global</display-name>
    <tlib-version>1.1</tlib-version>
    <short-name>gbl</short-name>
    <uri>http://java.sun.com/jsp/jstl/stu</uri>
    
    <function>
        <description>获得学生名称</description>
        <name>getStudentName</name>
        <function-class>com.fsats.synthesis.customizetag.util.GlobalUtil</function-class>
        <function-signature>java.lang.String getStudentName(int)</function-signature>
        <example>${stu:getStudentName(index)}</example>
    </function>
</taglib>
```

文件根标签头部是必须的，其次定义描述，显示名称，标签版本，短名称，uri。对于uri可以按示例格式定义，修改后面一个路径就好

然后是function标签，定义方法，依次是描述，名称，方法全类名，方法签名，示例。对于name就是${stu:name},需要正确定义，参数除基本数据类型外，均写完全限定名。可多参数传递。

可以为参数设置为对象类型，对象值可以通过model携带属性传递到jsp的，例如，项目中传递的student属性就是一个student对象，并直接作为参数，不必要再写${}了。

当然参数还可以是自定义的function，例如:${stu:getStudent(stu:getXxx(param))}。


<h3 id="a3">自定义tag文件</h3>
tag自定义文件主要用于对重复jsp代码的自定义，也可以进行其他操作

引用示例:

    <%@ taglib prefix="stu" tagdir="/WEB-INF/tags/stu" %>

自定义标签需要使用tagdir属性，路径到tag文件的目录，通过 **前缀:文件名**的方式使用自定义标签

示例是通过id获得对应的Student对象,通过ajax请求返回数据并设置到页面，返回的json数据可进行处理，只是转json的时候中文出现乱码问题没有解决。

在tag文件中，可使用jsp指令，tag，attribute，taglib，include等，不可使用page。也可以添加标签元素和js代码，完全可以当作jsp页面。

另外，只要引用了tld文件，依然是可以用静态方法调用的。


> 实例在customizetag包


<h2 id="b1">Js Mustache模板引擎</h2>

Mustache模板引擎需要引入mustache.min.js的js文件，它的官网在[Mustache](https://github.com/janl/mustache.js)

官网简单示例:

```
<!DOCTYPE HTML>
<html>
<body onload="loadUser()">
<div id="target">Loading...</div>
<script id="template" type="x-tmpl-mustache">
Hello {{ name }}!
</script>
</body>
</html>

function loadUser() {
  var template = $('#template').html();
  var rendered = Mustache.render(template, {name: "Luke"});
  $('#target').html(rendered);
}
```

定义script标签，为模板类型，通过{{}}设置属性,如{{name}},{{emp.name}},与${}一个道理。

js代码，先获取模板html，然后如果想要显示列表，那么可以拼接字符串，通过json循环，追加html模板字符串。

    Mustache.render(template, {name: "Luke"});

该方法可以将模板转换，属性设置，在第二个参数，json格式，key为模板属性名称，值为模板属性值。第一个参数为模板转换的字符串。

翻看view下的mustache文件下的jsp文件以及mustache包下的controller。


<h2 id="c1">jQuery TreeTable js</h2>

js文件包,statics文件夹下的treeTable文件夹，整个文件夹都是，少了文件可能就导致小三角显示不出来，不能打开关闭树。

默认表格样式不好看，所以添加了bootstrap的表格样式。

先得到list的json字符串，随后通过模板进行append，但要注意的是，模板的tr标签一定要有id和pid属性，一个是该实例id，一个是该实例的父级id。

另外需要通过addRow迭代方法按照顺序append显示，否则它不会自动排序

```
function addRow(list,tpl,data,pid) {
    for (var i=0;i<data.length;i++){
        var row = data[i];//获得某一个实例
        //判断该实例的父级id是否是传递来的pid，是则是其子级元素，将追加到后面
        if(row.parentId==pid){
            $(list).append(Mustache.render(tpl,{area:row,areatype:row.type,pid:pid}));
            addRow(list,tpl,data,row.id);
        }

    }
}
```
该排序，简而言之就是，首先循环，判断该父级id是否是传递的父级id，是则是父子级关系，会追加到其父的后面，然后再循环。

按着这个格式写就好。所有完毕后，通过$("#treeTable").treeTable({ expandable: true ,expandLevel : 5});显示，expandLevel表示拓展几级。

后台手动创建area list，用gson转为json字符串传递到后台可直接循环。

java类在jquerytreetable包中，jsp在bst/bstable.jsp，最重要的就是statics中包文件的的齐全。

> 如果console出现$('').treetabl不是一个函数的话，注意js引入是否正确，以及statics包是否完全导入项目。<br/>
> 另外row.type为数值，使用tld静态类时，无法使用，完全被转化为空。


<h2 id="d1">jquery DateTimer jeDate时间控件</h2>

添加jeDate插件,添加包到静态文件夹，jsp引入js和css，以及一个test.js文件。test.js文件主要就是定义文本框中日期字符串格式的。自己定义，如果不定义则js中会弹框。并且test.js必须放在body中的随后位置，以保证得到日期文本框的id

```
<form:form id="deptForm" action="${pageContext.request.contextPath}/dept/save" method="post" modelAttribute="dept">
    <form:label path="name">部门名称</form:label><form:input path="name"></form:input><br/>
    <form:label path="area">部门面积</form:label><form:input path="area"></form:input><br/>
    <form:label path="address">部门地址</form:label><form:input path="address"></form:input><br/>
    <form:label path="phone">部门电话</form:label><form:input path="phone"></form:input><br/>
    <form:label path="establishDate">成立日期</form:label>
    <input type="text" name="establishDate" value="<fmt:formatDate value="${dept.establishDate}"/>" class="jeinput" id="enYMD" placeholder="YYYY-MM-DD"/><br/>

    <input type="submit" value="提交">
</form:form>
```

对于日期控件，简单的日期，添加倒数第三行那一行就好，但是不能使用form:input控件当作日期文本框，因为这样会导致<fmt:formatDate>标签变成字符串。

此日期插件有更多的显示方式，如：面板主题颜色，区域范围，自定义格式，双击弹出，有效无效日期限制，直接显示日历等。

具体可查看jeDate包，也可以看官网[JEUI](http://www.jemui.com/index.html)里的jeDate控件。

另外如果你发现引入后导致400 bad request，那么可以详细看看form及其属性标签定义的对不对，如果没问题，**就看你是否有Date，String转换器，这是导致错误的最大可能。**如果是其他报错则查看jsp也main与controller是否编写错误。

StringToDate转换器配置如下:

```
<mvc:annotation-driven conversion-service="myConversionService"/>

<bean id="myConversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
        <set>
            <!-- 引入自己配置的自定义转换器，将String类型转换为Date日期 -->
            <bean class="com.fsats.synthesis.jqueryvalidate.converter.MyConversionDateToString">
                <constructor-arg name="patten" value="yyyy-MM-dd"/>
            </bean>
        </set>
    </property>
</bean>
```

> java文件在jqueryvalidate包，jsp在jvalidate文件夹下


<h2 id="e1">jQuery validate校验框架</h2>

引入js文件jquery.validate.min.js和messages_zh.js用于中文输出信息,还有必要的jquery.js文件

[jquery validate菜鸟教程](http://www.runoob.com/jquery/jquery-plugin-validate.html)

[jquery validate官网](https://jqueryvalidation.org/)及[官网演示案例](https://jqueryvalidation.org/files/demo/)

<h3 id="e2">默认标签校验规则</h3>

校验规则众多，许多规则名称，HTML5 Input标签都有。

像是取值为true的，如required、email、url、digits等，都可以直接写在class属性中，也可以单独写成一个属性。maxlength，range带值的这种，如果标签本来就有的就写上去，没有的也可以作为属性并赋值。

完成后，就可以进行校验,如:

```
$.validator.setDefaults({
    //使用其他方式代替默认的submit
    submitHandler: function(form) {
        alert("提交事件!");
        form.submit();
    }
});
$(function(){
    $("#deptForm").validate();
})
```

测试后，如果不符合条件就会出现默认错误信息。

<h3 id="e3">js设置校验规则</h3>

刚才校验规则都是写在标签里的，可以使用js代码写

rules属性可以设置规则

```
$(function(){
    $("#deptForm").validate({
        submitHandler: function(form) {
            alert("提交事件!");
        },
        rules:{
            name:"required",
            address:"required",
            phone:{
                required:true,
                maxlength:11
            },
            area:{
                required:true,
                digits:true
            },
            establishDate:"required"
        }
    });
})
```

<h3 id="e4">其他方法级问题</h3>

1. 使用其他方式代替type=submit提交

上面的示例代码是一种，注意:对于$.validator.setDefaults方法，只是设置默认和其他js校验代码，必须设置$("#deptForm").validate();才能校验，否则直接提交。

或者:

```
$().ready(function() {
 $("#signupForm").validate({
        submitHandler:function(form){
            alert("提交事件!");   
            form.submit();
        }    
    });
});
```

2. debug，只验证不提交表单

```
$("#signupForm").validate({
    debug:true
});
```

3. errorContainer，错误容器

显示或者隐藏验证信息，可以自动实现有错误信息出现时把容器属性变为显示，无错误时隐藏，用处不大。
errorContainer: "#messageBox1, #messageBox2"

没有太大用处

4. errorPlacement,更改错误信息显示的位置

默认放在元素后面

```
errorPlacement: function(error, element) {  
    error.appendTo(element.parent());  
}
```
你可以修改，函数内的代码段

5. 定义错误样式,定义类名为error的css即可

6. 异步验证

remote属性

示例:

```
remote: {
    url: "dept/remote",     //后台处理程序
    type: "post",               //数据发送方式
    dataType: "json",           //接受数据格式   
    data: {                     //要传递的数据
        name: function() {
            return $("input[name=name]").val();
        }
    }
}
```


7. 自定义验证

    addMethod(name, method, message);

示例:

```
jQuery.validator.addMethod("checkPhone", function(value, element) {
    var tel = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的手机号");
```

校验的话，只需要在rules对应属性中设置，checkPhone:true。或者标签中class="checkPhone",或标签属性,checkPhone="true"。


<h2 id="f1">zTree js框架</h2>

js包下载：[github地址](https://github.com/zTree/zTree_v3.git)

包大小约3-3MB，可整个导入项目静态文件夹下

<h3 id="f2">基本json使用，一次性加载完毕</h3>
    
必须要用到的初始化方法，用于初始化Tree

```
$.fn.zTree.init($("#treedata"),setting,zNodes);
```

该方法第一个参数为要展示的对象，setting为Tree设置，zNodes就是要展示的数据。

而展示对象object，必须是一个ul标签，且具有id和class="ztree"属性。

完整代码:

```
<script type="text/javascript">
    var zNodes=${data};
    var setting={
        data:{
            simpleData:{
                enable:true,
                idKey:"id",
                pIdKey:"pid",
                rootPId:""
            }
        }
    }
    $(function(){
        $.fn.zTree.init($("#treedata"),setting,zNodes);
    });
</script>

<div>
    <ul id="treedata" class="ztree"></ul>
</div>
```

<h3 id="f3">异步加载</h3>

对于异步加载来说，可以说很简单，但是新手的话，别人的博客如果没有提出重点，而你的类属性和他的类属性设置的还不一样，那么你就可能会像我一样出错。

然而找了一上午，终于看了官方的demo和response数据，才发现问题。

那么，如果你的问题是:首次加载一级节点,之后再点击就没任何反应，并且图标是文件。那么你的问题就和我一样了。

出现问题的原因:就是少了isParent属性。无法确定是否是父节点，只能认为是子节点。而这个isParent属性可以是类属性，也可以是treeNode的属性。

所以依据正常情况，你需要**为类设置一个isParent属性**，这个转json时有这个属性。而这个属性会让ztree判断为是否为父级，为true则显示为文件夹，false显示为文件。而你的数据无法显示，可能就少了这个属性。

现在根据isParent情况，分为两类，一个是有此属性，一个是没有此属性。

**1. 有isParent属性,那么只需要设置异步加载的选项(非常建议，省去很多不必要麻烦)**

```
var setting = {
    data: {
        key: {
            name: "name",
        },
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: 0
        }
    },
    async:{
        enable:true,
        autoParam:["id"],
        type:"post",
        url:"${pageContext.request.contextPath}/treedata/get"
    }
};

$(function(){
    $.fn.zTree.init($("#treedata"),setting);
})
```
另外注意的时，初始化树，需要将init放在$(function(){})中，否则将报错

    Cannot read property 'style' of null

ztree会依据你的isParent属性为true还是false，来判断图标如何显示。

**2. 数据库已经建好，且类属性不便更改(无法完整解决，图标都是文件夹)**

如果你的数据库或属性有level字段，并且你的层级结构一致，并不存在有的一级节点下显示文件，有的二级节点下显示文件的情况。

那么你可以通过异步选项的dataFilter属性方法来解决，该方法用于过滤传来的数据

```
dataFilter:function (treeId,parentNode,childNodes) {
    for (var i=0, l=childNodes.length; i<l; i++) {
        if()
        childNodes[i].isParent = true;
    }
    return childNodes;
}
```
参数分别为树容器的id值，父节点的treeNode对象，异步加载获得数据转换成树节点的集合。

treeNode对象的isParent属性表示是否为父级，与类中的isParent一样，是文件还是文件夹。

但是这样做出现的问题是，你的每一层每一项图标都是文件夹。

> 本项目是由于isParent属性情况导致，所以新建TestArea类和TestAreaDao接口，重新解决的。


<h2 id="g1">Mybatis分页插件PageHelper</h2>

[GitHub地址](https://github.com/pagehelper/Mybatis-PageHelper)

一下示例为最基本示例，详细内容看github中文档，及其他博客。

此示例，href属性跳转后台获得数据，并非ajax异步，导航只有首页，尾页，上一页，下一页。分页导航请在其他地方查找。

添加pom依赖

```
<dependency>
  <groupId>com.github.pagehelper</groupId>
  <artifactId>pagehelper</artifactId>
  <version>5.1.4</version>
</dependency>
```

service层设置

```
/**
 * 使用pageHelper分页
 * @param pageNum 第几页
 * @param pageSize 每页显示条数
 * @return
 */
public PageInfo<AreaTree> pageList(Integer pageNum,Integer pageSize){
    PageHelper.startPage(pageNum, pageSize);
    List<AreaTree> areaTreeList = areaTreeDao.findAll();
    PageInfo<AreaTree> pageInfo = new PageInfo<AreaTree>(areaTreeList);
    return pageInfo;
}
```

controller设置

```
@RequestMapping("list")
public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum){
    //model.addAttribute("data", areaTreeService.findAll());
    PageInfo<AreaTree> pageInfo = areaTreeService.pageList(pageNum, 15);
    model.addAttribute("pageInfo", pageInfo);
    return "pagination/page";
}
```

jsp设置

```
<body>
    <table>
        <c:forEach var="area" items="${pageInfo.list}">
            <tr>
                <td>${area.id}</td>
                <td>${area.name}</td>
                <td>${area.pid}</td>
            </tr>
        </c:forEach>
    </table>
<ul>
    <a href="/pagination/list?pageNum=1">首页</a>
    <a href="/pagination/list?pageNum=${pageInfo.prePage<1?1:pageInfo.prePage}">上一页</a>
    <span>${pageInfo.pageNum}</span>
    <a href="/pagination/list?pageNum=${pageInfo.nextPage>pageInfo.pages?pageInfo.pages:pageInfo.nextPage}">下一页</a>
    <a href="/pagination/list?pageNum=${pageInfo.pages}">尾页</a>
</ul>
```


<h2 id="h1">stephanwagner jbox弹框插件</h2>

stephanwagner jbox弹框插件可以说是很优美的弹框，与jquery jbox相比显得更有有活力一些。

[GitHub地址](https://github.com/StephanWagner/jBox)
[Demo演示地址](https://stephanwagner.me/jBox/)

由于该弹框插件在github上star将近1k，但使用的还是很少，博客出来的更少,而对于某些文章博客讲述的并不完整。具体参数也不详细。少了一个参数就出不来正常效果。

所以下载源码包后，Demo下的示例，找到你需要的某个案例，进行拷贝。对应拷贝，包括html和demo.js里的实例化jbox对象。

> 实例化jBox都应放在$(function(){})中

<h3 id="h2">基本提示框(全屏)</h3>

```
//基本提示框
new jBox('Modal', {
    attach: '#baseShow',
    height: 200,
    overlay:false,//是否覆盖页面(界面只有弹框，背景为灰色)
    title: '打开一个提示框',
    content: '这是一个提示框，你可以按键Esc或点击关闭按钮关闭'
});

<%--基本提示弹框--%>
<div id="baseShow" class="target-click">Click me</div>
```


<h3 id="h3">移动弹框</h3>

依据示例拷贝，该移动弹框，toggle效果，点击一次出现，再点击消失，并且框内数据可以保留。

```
<script type="text/javascript">
    $(function(){
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
    });
</script>

//移动弹框设置
<div id="show" class="target-click">Click me</div>
<div id="showBox" style="display: none">
    <form action="/jbox/save" type="post">
        <input type="text" name="id" value=""/>
        <input type="text" name="name" value=""/>
        <input type="submit" value="提交"/>
    </form>
</div>
```

+ title属性为标题，
+ content属性是内容，可以引用容器，将某个div等引入。
+ attach属性是触发弹框的id或class选择器

<h3 id="h4">弹框内容由ajax发起请求并显示</h3>

点击后，通过ajax属性操作，完美移植了$.ajax的回掉函数。

弹框的文本和内容均可以在回掉函数中重新再次设置。

```
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

<%--ajax弹框--%>
<div id="showAjax" class="target-click">Click me</div>
```

对于前台，可以使用线程睡眠，此时弹框中内容出现圆圈旋转，处于等待中。

<h3 id="h5">鼠标悬停显示信息</h3>

```
<%--鼠标悬停显示内容--%>
<span id="hover" class="target"> hover me</span>

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
```

可设置宽度，高度依据内容自动增高，delayOpen表示打开所需要的时间，delayClose表示关闭所需要的时间。

pointer表示弹框的位置，块级元素和行级元素可能出书位置不一样，需要通过此属性进行调整，right和left，单位为像素。

onOpen回调函数表示当弹框显示的时候做的事情，可以更改内容等其他操作，onClose回调函数与之相反。


其他样式查看源码的Demo。

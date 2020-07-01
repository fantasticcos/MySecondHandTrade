<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品发布</title>
</head>
	<style>
 *{
            margin: 0;
            padding: 0;
        }
        body{
  
            font-size: 18px;
            line-height: 1.8;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
             background: url(https://i.alipayobjects.com/e/201311/1V4o0zhQPN_src.jpg) no-repeat;
        }
        #person{
            margin-left: 80px;
            height: 100px;
            width: 200px;
            position: relative;
            
        }
        .desc span{
            position: absolute;
            margin-top: 0px;
            width: 80px;
        }
        
        h2{
            text-align: center;
        }
        .but{
            display: flex;
            flex-direction: row;
            align-items: center;
        }
        .b1{
            width: 50%;
            align-items: center;
            border: 0;
        }
        b2{
            width: 50%;
            align-items: center;
            border: 0;
        }
        span{
            display: flex;
        }
        #xxx{
            display: flex;
        }
        .in{
            width: 200px;
        }
        select{
            padding: 5px;
        }
        .t_form{
            width: 400px;
            align-items: center;
            background: rgb(252,252,252);
            box-shadow: 0px 1px 5px 0px;
            border-radius: 8px;
        }
        .banner{
            position:relative;
            background: url(./theme-pic.jpg) no-repeat 0 200px;
            margin:0 auto;
            width: 1000px;
             height:678px;
        }
		.add_promot{
			border: 1px solid #FFCC00;
			background-color: #ffffda;
			padding-left: 5px;
			padding-right: 5px;
			line-height: 20px;
		}
		.ok_promot{
			border: solid 1px #01be00;
			background-color: #e6ffe4;
			background-image: url(./li_ok.gif);
			background-repeat: no-repeat;
			background-position: 5px 2px;
			padding: 2px 5px 0px 25px ;
			line-height: 20px;
		}
		.error_promot{
			border: 1px solid #ff3300;
			background-color: #fff2e5;
			background-image: url(./li_err.gif);
			background-repeat: no-repeat;
			background-position: 5px 2px;
			padding: 2px 5px 0px 25px ;
			line-height: 20px;
		}

</style>
<body>

<div class="t_form">
			<div><h2 >发布商品</h2></div>
            <form action="distribute" method="post" enctype="multipart/form-data"  id="tform" onSubmit="return check(this)">
                商品名称:<input class="in" id="acc" type="text" name="goods"  
				placeholder="输入商品名称"
				onfocus="usernameFocus()"
				onblur="usernameBlur()"
				>*
				<div>
					类型：<select name="type" id="province"  >
								<option value ="衣服">-衣服-</option>
								<option value ="鞋">-鞋-</option>
								<option value ="家电">-家电-</option>
								<option value ="手机">-手机-</option>
								<option value ="珠宝">-珠宝-</option>
								<option value ="箱包">-箱包-</option>
								<option value ="手表">-手表-</option>
								<option value ="乐器">-乐器-</option>
								<option value ="器械">-器械-</option>
								<option value ="学习">-学习-</option>
								<option value ="书本">-书本-</option>
							 </select>
				</div>
                决定价格:<input class="in" id="pwd" type="text" name="price">*
                <br>
                <div class="desc">
                    <span>描述:</span>
                    <textarea name="desc" id="person" cols="30" rows="10"></textarea>
                </div>
                <div>
             		选择图片:
             		<input type="file" name="pic">
             	</div>
                <div class="but">
                    <div class="b1">
                        <button id="btn" type="submit" >提交</button>
                    </div>
                    <div class="b2">
                        <button >取消</button>
                    </div>
                </div>
                
            </form>
        </div>
</body>
</html>
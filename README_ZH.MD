# 批量删除github上的项目1

## 项目源起
之前在github上fork了很多项目，最后打算整理下自己的github账号项目，
在github上找到一个deletegithubproject(https://github.com/l294265421/deletegithubproject)项目，发现有些问题。本项目在此基础上加以完善，方便使用。

## 使用方法
1. 先配置conf目录下的project_name和user_info.properites文件，project_name文件里放入要删除的项目名称，一行一个；user_info.properites文件配置github登陆名、密码和用户名。
2. 运行com.liyuncong.application.deletegithubproject.main.Main文件

## 注意
1. 测试SeleniumDeleter使用的chrome浏览器版本为75.0.3770.140(需要和当前使用的chrome版本一致)。chrome driver 历史版本地址(http://chromedriver.chromium.org/downloads)
2. 只支持windows操作系统
3. 修改删除按钮和确认删除按钮的xPath
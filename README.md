Git的使用：
    1.先到本地目标文件夹下打开git终端，初始化为本地仓库
        git init
    2.创建ssh秘钥
        ssh-keygen -t rsa   （然后一直enter）
    3.将本地工程加入本地仓库中，并设置本次提交及其注释
        git add .   （.表示所有文件）
        git commit -m "first commit"
		
		当修改后的文件再提交：
			
    4.将本地仓库中的文件push到远程仓库中：先连接，然后推送到指定分支上（ 默认master分支）
        git remote add origin git@github.com:liujingxiang971018/leetcode.git
		
        git branch -M main
        git push -u origin main
	
	5.从远程仓库克隆到本地仓库
        git clone git@github.com:liujingxiang971018/leetcode.git
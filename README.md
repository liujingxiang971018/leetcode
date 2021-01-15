Git的使用：

    0.第一次使用git，需要先配置本地仓库的信息
        git config user.name "liujingxiang"
        git config user.email "liujingxiang971018@163.com"

    1.先到本地目标文件夹下打开git终端，初始化为本地仓库
        git init

    2.创建ssh秘钥
        ssh-keygen -t rsa   （然后一直enter）

    3.将本地工程加入本地仓库中，并设置本次提交及其注释
        git add .   （.表示所有文件）
        git commit -m "first commit"

        3.1.如果需要忽略一些文件，则需要新建一个.gitignore文件记录需要忽略的文件
            touch .gitignore
            echo ".idea/" >> .gitignore
            echo "out/" >> .gitignore
            echo "*.iml" >> .gitignore

        3.2.在本地修改后的文件再提交到本地仓库：
            git commit -am "second commit"

    4.将本地仓库中的文件push到远程仓库中：先连接，然后推送到指定分支上（ 默认master分支）
        git remote add origin git@github.com:liujingxiang971018/leetcode.git

        git branch -M main
        git push -u origin main

    5.从远程仓库克隆到本地仓库
        git clone git@github.com:liujingxiang971018/leetcode.git

        在远程仓库修改后的文件，拉取到本地：
        git pull -v --progress origin

    6.清楚缓存区中的所有文件
        git rm -r --cached .

    7.idea中可以进行git版本控制
        7.1.在settings中绑定git
        7.2.在VCS工具中Import into Version Control中提交到本地仓库，在push到远程仓库

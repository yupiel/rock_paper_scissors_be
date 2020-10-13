echo -e "\n\033[35;1;4mStarting slave work...\033[0m"
echo -e "\n\033[34;1;4mDocker build...\033[0m\n"
docker build -t yupiel/rock_paper_scissors_be .
#echo -e "\n\033[34;1;4mHeroku Login...\033[0m\n"
#heroku login
echo -e "\n\033[34;1;4mHeroku Container Login...\033[0m\n"
heroku container:login
echo -e "\n\033[34;1;4mPushing image to Heroku...\033[0m\n"
heroku container:push web --app mysterious-taiga-40531
echo -e "\n\033[34;1;4mReleasing image to Heroku...\033[0m\n"
heroku container:release web --app mysterious-taiga-40531
echo -e "\n\033[34;1;4mShowing logs...\033[0m\n"
heroku logs --tail --app mysterious-taiga-40531
echo -e "\n\033[35;1;4mFinishing slave work...\033[0m\n"

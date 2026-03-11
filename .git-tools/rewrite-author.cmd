@echo off
setlocal

for /f %%i in ('git log -1 --format^=%%ae') do set AUTHOR_EMAIL=%%i

if /I "%AUTHOR_EMAIL%"=="codex@local" (
  set GIT_COMMITTER_NAME=Yash Lohare
  set GIT_COMMITTER_EMAIL=yashlohare@gmail.com
  git commit --amend --no-edit --author="Yash Lohare <yashlohare@gmail.com>"
)

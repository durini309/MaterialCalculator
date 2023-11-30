#!/bin/bash

latest_tag=$(git describe --tags --abbrev=0)

commit_log=$(git log --pretty=format:"%s" $latest_tag..HEAD)

read -p "Add new tag (latest tag: $latest_tag): " new_tag
read -p "Release title: " tag_message

git tag -a "$new_tag" -m "$tag_message"$'\n\n'"$commit_log"

git push origin "$new_tag"
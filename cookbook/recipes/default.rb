#
# Cookbook Name:: cookbook
# Recipe:: default
#
# Copyright (c) 2015 Andrew Pennebaker

include_recipe 'apt'

include_recipe 'java'

template '/etc/dropwizard.yml' do
  source 'dropwizard.yml.erb'
end

package 'curl' do
end

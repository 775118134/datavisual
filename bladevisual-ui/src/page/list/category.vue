<template>
    <div class="map">
        <avue-crud :option="option" v-model="form" @row-save="rowSave" @row-update="rowUpdate" @refresh-change="refreshChange" @row-del="rowDel" @size-change="handleSizeChange" :page="page" @current-change="handleCurrentChange" :before-open="beforeOpen" :data="data"></avue-crud>
    </div>
</template>

<script>
    import { getList, getObj, addObj, delObj, updateObj } from '@/api/category'
    export default {
        data() {
            return {
                form: {},
                data: [],
                page: {
                    currentPage: 1,
                    pageSize: 10,
                    total: 0
                },
                option: {
                    index: true,
                    align: 'center',
                    headerAlign: 'center',
                    column: [{
                            label: '模块名',
                            prop: 'categoryKey',
                            rules: [{
                                required: true,
                                message: "请输入模块名",
                                trigger: "blur"
                            }]
                        },
                        {
                            label: '模块值',
                            prop: 'categoryValue',
                            rules: [{
                                required: true,
                                message: "请输入模块值",
                                trigger: "blur"
                            }]
                        }
                    ]
                }
            }
        },
        created() {
            this.getList()
        },
        methods: {
            vaildData(id) {
                //              return [0, 1].includes(id)
                return false;
            },
            beforeOpen(done, type) {
                if(type == 'edit') {
                    getObj(this.form.id).then(res => {
                        const data = res.data;
                        this.form = data
                        done()
                    }).catch(() => {
                        return false;
                    });
                } else {
                    done()
                }
            },
            rowDel(row, index) {
                if(this.vaildData(index)) {
                    this.$message.error('例子模板不允许修改')
                    return false;
                }
                this.$confirm('此操作将永久删除, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    delObj(row.id).then(() => {
                        this.$message.success('删除成功');
                        this.getList()
                    })
                }).catch(() => {

                });

            },
            rowUpdate(row, index, done) {
                if(this.vaildData(index)) {
                    this.$message.error('例子模板不允许修改')
                    return false;
                }
                updateObj(row).then(() => {
                    this.$message.success('修改成功');
                    this.getList()
                    done();
                })
            },
            rowSave(row, done) {
                addObj(row).then(() => {
                    this.$message.success('新增成功');
                    this.getList()
                    done();
                })
            },
            handleCurrentChange(val) {
                this.page.currentPage = val;
                this.getList();
            },
            handleSizeChange(val) {
                this.page.pageSize = val;
                this.getList();
            },
            refreshChange() {
                this.getList();
            },
            getList() {
                getList({
                    pageNum: this.page.currentPage,
                    pageSize: this.page.pageSize,
                }).then(res => {
                    const data = res.data;
                    this.page.total = data.total;
                    this.data = data.records;
                })
            }
        }
    }
</script>

<style lang="scss" scoped>
    .map {
        padding: 30px;
        width: 100%;
        .title {
            display: block;
            margin-bottom: 30px;
            padding: 0 50px;
            font-size: 20px;
        }
    }
</style>
<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="EditPostQuestions.aspx.vb" Inherits="WebApplication1.WebForm14" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
    <h3 style="color: blue">Edit Post Course</h3>
    <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Question Title</label>
                                    <div class="col-md-12">
                                        <asp:TextBox class="form-control" MaxLength="150" ID="TextBox1" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>

     <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Option 1</label>
                                    <div class="col-md-12">
                                        <asp:TextBox class="form-control" MaxLength="150" ID="TextBox2" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>

     <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Option 2</label>
                                    <div class="col-md-12">
                                        <asp:TextBox class="form-control" MaxLength="150" ID="TextBox3" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>

     <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Option 3</label>
                                    <div class="col-md-12">
                                        <asp:TextBox class="form-control" MaxLength="150" ID="TextBox4" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>

     <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Option 4</label>
                                    <div class="col-md-12">
                                        <asp:TextBox class="form-control" MaxLength="150" ID="TextBox5" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>


     <div class="form-group">
                                    <label style="color: black" class="col-md-12">Choose Correct Option</label>
                                    <div class="col-md-12">
                                        <asp:DropDownList CssClass="form-control" ID="DropDownList1" runat="server">
                                            <asp:ListItem>Option 1</asp:ListItem>
                                            <asp:ListItem>Option 2</asp:ListItem>
                                            <asp:ListItem>Option 3</asp:ListItem>
                                            <asp:ListItem>Option 4</asp:ListItem>
                                        </asp:DropDownList>
                                        <br />
                                    </div>
                                </div>

    <asp:Button ID="Button1" CssClass="btn btn-block btn-warning" runat="server" Text="Save" />

</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
